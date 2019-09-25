import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate now = LocalDate.now();
        DayOfWeek dayOfWeek = DayOfWeek.from(now.getDayOfWeek());

        System.out.printf("Dia: %s %n", now.format(formatter));
        now = getProximoDiaUtil(now, dayOfWeek);
        System.out.printf("Dia: %s %n", now.format(formatter));
    }

    private static LocalDate getProximoDiaUtil(LocalDate now, DayOfWeek dayOfWeek) {
        while ((dayOfWeek == DayOfWeek.SATURDAY) || (dayOfWeek == DayOfWeek.SUNDAY)) {
//            dayOfWeek.plus(1);
            now = now.plusDays(1);
            dayOfWeek = DayOfWeek.from(now.getDayOfWeek());
        }
        return now;
    }
}
