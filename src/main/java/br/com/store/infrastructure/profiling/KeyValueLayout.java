package br.com.store.infrastructure.profiling;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyValueLayout extends Layout {

    private static final String DEFAULT_MATCH_PATTERN =
        "start\\[(\\d+)\\] time\\[(\\d+)\\] tag\\[(.*?)\\](?: message\\[(.*?)\\])?";
    private static final int GROUP_2 = 2;
    private static final int GROUP_3 = 3;
    private static final int GROUP_4 = 4;

    private static Pattern pattern = Pattern.compile(DEFAULT_MATCH_PATTERN);
    private static final String TIME = "Time=";
    private static final String METHOD = "Method=";
    private static final String COMMA = ",";

    @Override
    public String format(LoggingEvent event) {

        String result = null;

        Object message = event.getMessage();

        if (message != null) {
            if (message instanceof String && isPotentiallyValid((String) message)) {
                result = formatTimingMessage((String) message);
            } else {
                result = message.toString();
            }
        }

        return result;
    }

    /**
     * Interpreta uma mensagem plain/text e formata mensagem no layout
     * chave=valor.
     */
    protected String formatTimingMessage(String message) {

        Matcher matcher = pattern.matcher(message);
        MatchResult matchResult = null;
        if(matcher.find()) {
            matchResult = matcher.toMatchResult();
        }

        if (matchResult != null) {

            String time = matchResult.group(GROUP_2);
            String method = matchResult.group(GROUP_3);
            String args = matchResult.group(GROUP_4);

            StringBuilder str = new StringBuilder();

            str.append(TIME);
            str.append(time);
            str.append(COMMA);
            str.append(METHOD);
            str.append(method);
            str.append(COMMA);

            if (!StringUtils.isBlank(args)) {
                str.append(args);
            }

            str.append(LINE_SEP);

            return str.toString();
        }

        return null;
    }

    /**
     * Verifica se é uma mensagem valida para o parser.
     */
    private boolean isPotentiallyValid(String message) {
        return message.startsWith("start");
    }

    @Override
    public boolean ignoresThrowable() {
        return true;
    }

    public void activateOptions() {
    }
}
