package ua.training.controller.util;

import ua.training.controller.exception.CommandException;
import ua.training.controller.service.CruiseService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static String getActionFromURI(String URI) {
        URI = URI.substring(1, URI.length());
        String[] s = URI.split("/");
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i].matches("[A-Za-z_]+")) {
                return s[i];
            }
        }
        throw new CommandException("null action");
    }

    public static int getIdFromURI(String URI) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(URI);
        int id;
        String m = "";
        while (matcher.find()) {
            m = matcher.group();
        }
        try {
            id = Integer.parseInt(m);
        } catch (NumberFormatException e) {
            id = 0;
        }
        return id;
    }

    public static String calculateDuration(LocalDateTime from, LocalDateTime to) {
        LocalDateTime fromTemp = LocalDateTime.from(from);
        long years = fromTemp.until(to, ChronoUnit.YEARS);
        fromTemp = fromTemp.plusYears(years);

        long months = fromTemp.until(to, ChronoUnit.MONTHS);
        fromTemp = fromTemp.plusMonths(months);

        long days = fromTemp.until(to, ChronoUnit.DAYS);
        fromTemp = fromTemp.plusDays(days);

        long hours = fromTemp.until(to, ChronoUnit.HOURS);
        fromTemp = fromTemp.plusHours(hours);

        long minutes = fromTemp.until(to, ChronoUnit.MINUTES);
        fromTemp = fromTemp.plusMinutes(minutes);

        if (years != 0) {
            return years + "years, " + months + "months, " + days + "d. " + hours + "hours, " + minutes + "minutes";
        } else if (months != 0) {
            return months + "months, " + days + "days, " + hours + "hours, " + minutes + "minutes";
        } else if (days != 0) {
            return days + "days, " + hours + "hours," + minutes + "minutes";
        } else if (hours != 0) {
            return hours + "hours," + minutes + "minutes";
        } else if (minutes != 0) {
            return minutes + "m.";
        } else {
            return null;
        }

    }

    public static int getPage(int quantity, int page) {
        int limitCruise = CruiseService.LIMIT_CRUISE;
        int maxPage = (quantity % limitCruise == 0) ? quantity / limitCruise :
                quantity / limitCruise + 1;
        if (page > maxPage)
            throw new CommandException("so big page number");
        return maxPage;
    }


}
