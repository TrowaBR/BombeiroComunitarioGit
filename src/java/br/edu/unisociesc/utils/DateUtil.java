package br.edu.unisociesc.utils;

import static br.edu.unisociesc.dao.AgendamentoDAO.NUM_PERIODOS;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String datePostgre(Date date) {
        return "'" + FORMAT.format(date) + "'";
    }

    public static int periodo(Calendar calendar) {
        return (calendar.get(Calendar.MONTH)-1) / NUM_PERIODOS;
    }
    
    public static Calendar inicioDia(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public static Date inicioDia(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return inicioDia(calendar).getTime();
    }

    public static Calendar terminoDia(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar;
    }

    public static Date terminoDia(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return terminoDia(calendar).getTime();
    }

    public static Calendar inicioMes(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return inicioDia(calendar);
    }

    public static Date inicioMes(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return inicioMes(calendar).getTime();
    }

    public static Calendar terminoMes(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return terminoDia(calendar);
    }

    public static Date terminoMes(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return terminoMes(calendar).getTime();
    }

    public static Calendar inicioPeriodo(Calendar calendar) {
        calendar.set(Calendar.MONTH, (periodo(calendar) * NUM_PERIODOS) + 1);
        return inicioMes(calendar);
    }

    public static Date inicioPeriodo(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return inicioPeriodo(calendar).getTime();
    }

    public static Calendar terminoPeriodo(Calendar calendar) {
        calendar.set(Calendar.MONTH, (periodo(calendar) * NUM_PERIODOS) + NUM_PERIODOS);
        return terminoMes(calendar);
    }

    public static Date terminoPeriodo(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return terminoPeriodo(calendar).getTime();
    }
}