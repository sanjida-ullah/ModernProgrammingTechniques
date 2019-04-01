public class TextbookStuff {
  public static void main (String [] args) {
    int hour = 13;
    int minute= 23;
    System.out.print(timeString(hour, minute));
  }
    public static String timeString(int hour, int minute) {
String ampm;
if (hour < 12) {
ampm = "AM";
if (hour == 0) {
hour = 12; // midnight
}
} else {
ampm = "PM";
hour = hour - 12;
}
return String.format("%02d:%02d %s", hour, minute, ampm);
}
}
