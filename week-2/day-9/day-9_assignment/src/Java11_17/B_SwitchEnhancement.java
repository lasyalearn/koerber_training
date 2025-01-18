package Java11_17;

public class B_SwitchEnhancement {
    public static void main(String[] args) {
        //java 6 u can only use char or int long: switch
        //java 7: string can also be used
        //java 13+ to simply the syntex of switch case


        // we can combine the common cases
        //to avoid using break statements by adding ->
        // no need to use defualt
        //switch can also be sued as an expression
        //yield for returning multiple values

        enum WeekDay {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        WeekDay day = WeekDay.TUESDAY;
        switch (day) {
            case MONDAY,WEDNESDAY,FRIDAY -> System.out.println("Let's meet!");

            case TUESDAY,THURSDAY,SATURDAY -> System.out.println("no meeting!");

            case SUNDAY-> System.out.println("Let's meet (although Sunday should be a free day, man!)!");


        };
//        enum WeekDay {
//            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
//        }
//
//        WeekDay day = WeekDay.TUESDAY;
//        switch (day) {
//            case MONDAY:
//                System.out.println("Let's meet!");
//                break;
//            case TUESDAY:
//                System.out.println("no meeting!");
//                break;
//            case WEDNESDAY:
//                System.out.println("Let's meet!");
//                break;
//            case THURSDAY:
//                System.out.println("no meeting!");
//                break;
//            case FRIDAY:
//                System.out.println("Let's meet!");
//                break;
//            case SATURDAY:
//                System.out.println("no meeting!");
//                break;
//            case SUNDAY:
//                System.out.println("Let's meet (although Sunday should be a free day, man!)!");
//                break;
//            default:
//                System.out.println("Do I really need this?!");
//                break;
//        }


    }
}