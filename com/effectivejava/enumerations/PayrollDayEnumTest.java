package com.effectivejava.enumerations;

public class PayrollDayEnumTest {
    public static void main(String[] args) {

        for (PayrollDay payrollDay : PayrollDay.values()) {
            System.out.println(payrollDay.payType);
        }
    }

    //  the strategy enum pattern
    private enum PayrollDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
        SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

        private final PayType payType;

        PayrollDay(PayType payType) {
            this.payType = payType;
        }

        PayrollDay() {
            this(PayType.WEEKDAY);
        }

        int pay(int minutesWorked, int payRate) {
            return payType.pay(minutesWorked, payRate);
        }

        //  the strategy enum type
        private enum PayType {
            WEEKDAY {
                int overtimePay(int minsWorked, int payRate) {
                    return minsWorked <= MINS_PER_SHIFFT ? 0 :
                            (minsWorked - MINS_PER_SHIFFT) * payRate / 2;
                }
            },
            WEEKEND {
                int overtimePay(int minsWorked, int payRate) {
                    return minsWorked * payRate / 2;
                }
            };

            abstract int overtimePay(int mins, int payRate);

            private static final int MINS_PER_SHIFFT = 8 * 60;

            int pay(int minsWorked, int payRate) {
                int basePay = minsWorked * payRate;
                return basePay + overtimePay(minsWorked, payRate);
            }
        }
    }
}