//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ddggddess.ddggddess.event;

import org.bukkit.ChatColor;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CMIChatColor {
    private static final Map<Character, CMIChatColor> BY_CHAR = new HashMap();
    private static final Map<String, CMIChatColor> BY_NAME = new HashMap();
    private static final LinkedHashMap<String, CMIChatColor> CUSTOM_BY_NAME = new LinkedHashMap();
    private static final Map<String, CMIChatColor> CUSTOM_BY_HEX = new HashMap();
    private static final TreeMap<String, CMIChatColor> CUSTOM_BY_RGB = new TreeMap();
    public static final String colorReplacerPlaceholder = "＆";
    public static final String colorHexReplacerPlaceholder = "{＆#";
    public static final String colorFontPrefix = "{@";
    public static final String colorCodePrefix = "{#";
    public static final String colorCodeSuffix = "}";
    public static final String hexColorRegex = "(\\{#)([0-9A-Fa-f]{6}|[0-9A-Fa-f]{3})(\\})";
    public static final Pattern hexColorRegexPattern;
    public static final Pattern hexColorRegexPatternLast;
    public static final Pattern hexDeColorNamePattern;
    public static final String ColorNameRegex = "(\\{#)([a-zA-Z_]{3,})(\\})";
    public static final Pattern hexColorNamePattern;
    public static final Pattern hexColorNamePatternLast;
    public static final String ColorFontRegex = "(\\{@)([a-zA-Z_]{3,})(\\})";
    public static final Pattern gradientPattern;
    public static final String hexColorDecolRegex = "(&x)(&[0-9A-Fa-f]){6}";
    public static final Pattern postGradientPattern;
    public static final Pattern post2GradientPattern;
    public static final Pattern fullPattern;
    public static final Pattern formatPattern;
    public static final CMIChatColor BLACK;
    public static final CMIChatColor DARK_BLUE;
    public static final CMIChatColor DARK_GREEN;
    public static final CMIChatColor DARK_AQUA;
    public static final CMIChatColor DARK_RED;
    public static final CMIChatColor DARK_PURPLE;
    public static final CMIChatColor GOLD;
    public static final CMIChatColor GRAY;
    public static final CMIChatColor DARK_GRAY;
    public static final CMIChatColor BLUE;
    public static final CMIChatColor GREEN;
    public static final CMIChatColor AQUA;
    public static final CMIChatColor RED;
    public static final CMIChatColor LIGHT_PURPLE;
    public static final CMIChatColor YELLOW;
    public static final CMIChatColor WHITE;
    public static final CMIChatColor OBFUSCATED;
    public static final CMIChatColor BOLD;
    public static final CMIChatColor STRIKETHROUGH;
    public static final CMIChatColor UNDERLINE;
    public static final CMIChatColor ITALIC;
    public static final CMIChatColor RESET;
    public static final CMIChatColor HEX;
    private char c;
    private boolean color;
    private boolean isReset;
    private Pattern pattern;
    private int redChannel;
    private int greenChannel;
    private int blueChannel;
    private String hexCode;
    private String name;

    static {
        CMICustomColors[] var3;
        int var2 = (var3 = CMICustomColors.values()).length;

        for(int var1 = 0; var1 < var2; ++var1) {
            CMICustomColors var0 = var3[var1];
            CUSTOM_BY_NAME.put(var0.name().toLowerCase().replace("_", ""), new CMIChatColor(var0.toString(), var0.getHex()));
            CUSTOM_BY_HEX.put(var0.getHex().toLowerCase(), new CMIChatColor(var0.toString(), var0.getHex()));
        }

        for(float var5 = 0.0F; var5 <= 1.0F; var5 = (float)((double)var5 + 0.1D)) {
            for(float var6 = 0.1F; var6 <= 1.0F; var6 = (float)((double)var6 + 0.1D)) {
                for(float var7 = 0.0F; var7 <= 1.0F; var7 = (float)((double)var7 + 0.03D)) {
                    Color var8 = Color.getHSBColor(var7, var5, var6);
                    StringBuilder var4 = (new StringBuilder()).append(Integer.toHexString((var8.getRed() << 16) + (var8.getGreen() << 8) + var8.getBlue() & 16777215));

                    while(var4.length() < 6) {
                        var4.append("0" + var4);
                    }

                    getClosest(var4.toString());
                }
            }
        }

        hexColorRegexPattern = Pattern.compile("(\\{#)([0-9A-Fa-f]{6}|[0-9A-Fa-f]{3})(\\})");
        hexColorRegexPatternLast = Pattern.compile("(\\{#)([0-9A-Fa-f]{6}|[0-9A-Fa-f]{3})(\\})(?!.*\\{#)");
        hexDeColorNamePattern = Pattern.compile("((&|§)x)(((&|§)[0-9A-Fa-f]){6})");
        hexColorNamePattern = Pattern.compile("(\\{#)([a-zA-Z_]{3,})(\\})");
        hexColorNamePatternLast = Pattern.compile("(\\{#)([a-zA-Z_]{3,})(\\})(?!.*\\{#)");
        gradientPattern = Pattern.compile("(\\{(#[^\\{]*?)>\\})(.*?)(\\{(#.*?)<(>?)\\})");
        postGradientPattern = Pattern.compile("((\\{#)([0-9A-Fa-f]{6}|[0-9A-Fa-f]{3})(\\})|(\\{#)([a-zA-Z_]{3,})(\\}))(.)((\\{#)([0-9A-Fa-f]{6}|[0-9A-Fa-f]{3})(\\})|(\\{#)([a-zA-Z_]{3,})(\\}))");
        post2GradientPattern = Pattern.compile("((\\{#)([0-9A-Fa-f]{6}|[0-9A-Fa-f]{3})(\\})|(\\{#)([a-zA-Z_]{3,})(\\}))(.)(((\\{#)([0-9A-Fa-f]{6}|[0-9A-Fa-f]{3})(\\})|(\\{#)([a-zA-Z_]{3,})(\\}))(.))+");
        fullPattern = Pattern.compile("(&[0123456789abcdefklmnorABCDEFKLMNOR])|(\\{#)([0-9A-Fa-f]{6}|[0-9A-Fa-f]{3})(\\})|(\\{#)([a-zA-Z_]{3,})(\\})|(\\{@)([a-zA-Z_]{3,})(\\})");
        formatPattern = Pattern.compile("(&[klmnorKLMNOR])");
        BLACK = new CMIChatColor("Black", '0', 0, 0, 0);
        DARK_BLUE = new CMIChatColor("Dark_Blue", '1', 0, 0, 170);
        DARK_GREEN = new CMIChatColor("Dark_Green", '2', 0, 170, 0);
        DARK_AQUA = new CMIChatColor("Dark_Aqua", '3', 0, 170, 170);
        DARK_RED = new CMIChatColor("Dark_Red", '4', 170, 0, 0);
        DARK_PURPLE = new CMIChatColor("Dark_Purple", '5', 170, 0, 170);
        GOLD = new CMIChatColor("Gold", '6', 255, 170, 0);
        GRAY = new CMIChatColor("Gray", '7', 170, 170, 170);
        DARK_GRAY = new CMIChatColor("Dark_Gray", '8', 85, 85, 85);
        BLUE = new CMIChatColor("Blue", '9', 85, 85, 255);
        GREEN = new CMIChatColor("Green", 'a', 85, 255, 85);
        AQUA = new CMIChatColor("Aqua", 'b', 85, 255, 255);
        RED = new CMIChatColor("Red", 'c', 255, 85, 85);
        LIGHT_PURPLE = new CMIChatColor("Light_Purple", 'd', 255, 85, 255);
        YELLOW = new CMIChatColor("Yellow", 'e', 255, 255, 85);
        WHITE = new CMIChatColor("White", 'f', 255, 255, 255);
        OBFUSCATED = new CMIChatColor("Obfuscated", 'k', false);
        BOLD = new CMIChatColor("Bold", 'l', false);
        STRIKETHROUGH = new CMIChatColor("Strikethrough", 'm', false);
        UNDERLINE = new CMIChatColor("Underline", 'n', false);
        ITALIC = new CMIChatColor("Italic", 'o', false);
        RESET = new CMIChatColor("Reset", 'r', false, true);
        HEX = new CMIChatColor("Hex", 'x', false, false);
    }

    private static String charEscape(String var0) {
        StringBuilder var1 = new StringBuilder();

        for(int var2 = 0; var2 < var0.length(); ++var2) {
            char var3 = var0.charAt(var2);
            switch(var3) {
                case '\b':
                    var1.append("\\b");
                    continue;
                case '\t':
                    var1.append("\\t");
                    continue;
                case '\n':
                    var1.append("\\n");
                    continue;
                case '\f':
                    var1.append("\\f");
                    continue;
                case '\r':
                    var1.append("\\r");
                    continue;
                case '"':
                    var1.append("\\\"");
                    continue;
                case '/':
                    var1.append("/");
                    continue;
                case '\\':
                    var1.append("\\\\");
                    continue;
            }

            if (var3 >= 0 && var3 <= 31 || var3 >= 127 && var3 <= 159 || var3 >= 8192 && var3 <= 8447) {
                String var4 = Integer.toHexString(var3);
                var1.append("\\u");

                for(int var5 = 0; var5 < 4 - var4.length(); ++var5) {
                    var1.append('0');
                }

                var1.append(var4.toUpperCase());
            } else {
                var1.append(var3);
            }
        }

        return var1.toString();
    }

    private static String escape(String var0) {
        return var0.replace("#", "\\#").replace("{", "\\{").replace("}", "\\}");
    }

    public CMIChatColor(String var1, char var2, int var3, int var4, int var5) {
        this(var1, var2, true, false, var3, var4, var5);
    }

    public CMIChatColor(String var1) {
        this((String)null, var1);
    }

    public CMIChatColor(String var1, String var2) {
        this.color = true;
        this.isReset = false;
        this.pattern = null;
        this.hexCode = null;
        if (var2.startsWith("#")) {
            var2 = var2.substring(1);
        }

        this.hexCode = var2;
        this.name = var1;

        try {
            this.redChannel = Integer.valueOf(this.hexCode.substring(0, 2), 16);
            this.greenChannel = Integer.valueOf(this.hexCode.substring(2, 4), 16);
            this.blueChannel = Integer.parseInt(this.hexCode.substring(4, 6), 16);
        } catch (Throwable var4) {
            this.hexCode = null;
        }

    }

    public CMIChatColor(String var1, char var2, Boolean var3) {
        this(var1, var2, var3, false);
    }

    public CMIChatColor(String var1, char var2, Boolean var3, Boolean var4) {
        this(var1, var2, var3, var4, -1, -1, -1);
    }

    public CMIChatColor(String var1, char var2, Boolean var3, Boolean var4, int var5, int var6, int var7) {
        this.color = true;
        this.isReset = false;
        this.pattern = null;
        this.hexCode = null;
        this.name = var1;
        this.c = var2;
        this.color = var3;
        this.isReset = var4;
        this.pattern = Pattern.compile("(?i)(&[" + var2 + "])");
        this.redChannel = var5;
        this.greenChannel = var6;
        this.blueChannel = var7;
        if (!Version.isCurrentLower(Version.v1_16_R1) || !var1.equalsIgnoreCase("Hex")) {
            BY_CHAR.put(var2, this);
            BY_NAME.put(this.getName().toLowerCase().replace("_", ""), this);
        }
    }

    public static String processGradient(String var0) {
        Matcher var1 = gradientPattern.matcher(var0);

        while(true) {
            String var2;
            CMIChatColor var3;
            CMIChatColor var4;
            do {
                do {
                    if (!var1.find()) {
                        return var0;
                    }

                    var2 = var1.group();
                    var3 = getColor("{#" + var1.group(2).replace("#", "") + "}");
                    var4 = getColor("{#" + var1.group(5).replace("#", "") + "}");
                } while(var3 == null);
            } while(var4 == null);

            String var5 = var1.group(3);
            boolean var6 = !var1.group(6).isEmpty();
            StringBuilder var7 = new StringBuilder();
            Set var8 = getFormats(var5);
            var5 = stripColor(var5);

            for(int var9 = 0; var9 < var5.length(); ++var9) {
                char var10 = var5.charAt(var9);
                int var11 = var5.length();
                var11 = var11 < 2 ? 2 : var11;
                double var12 = (double)var9 * 100.0D / (double)(var11 - 1);
                CMIChatColor var14 = mixColors(var3, var4, var12);
                var7.append("{#" + var14.getHex() + "}");
                if (!var8.isEmpty()) {
                    Iterator var16 = var8.iterator();

                    while(var16.hasNext()) {
                        CMIChatColor var15 = (CMIChatColor)var16.next();
                        var7.append("&" + var15.getChar());
                    }
                }

                var7.append(String.valueOf(var10));
            }

            if (var6) {
                var7.append("{#" + var1.group(5).replace("#", "") + ">" + "}");
            }

            var0 = var0.replace(var2, var7.toString());
            if (var6) {
                var0 = processGradient(var0);
            }
        }
    }

    public static String translate(String var0) {
        if (var0 == null) {
            return null;
        } else {
            var0 = processGradient(var0);
            if (var0.contains("{#")) {
                String var2;
                StringBuilder var3;
                for(Matcher var1 = hexColorRegexPattern.matcher(var0); var1.find(); var0 = var0.replace(var2, var3.toString())) {
                    var2 = var1.group();
                    var3 = new StringBuilder("§x");
                    char[] var7;
                    int var6 = (var7 = var2.substring(2, var2.length() - 1).toCharArray()).length;

                    for(int var5 = 0; var5 < var6; ++var5) {
                        char var4 = var7[var5];
                        var3.append('§').append(var4);
                        if (var2.substring(2, var2.length() - 1).length() == 3) {
                            var3.append('§').append(var4);
                        }
                    }
                }

                Matcher var11 = hexColorNamePattern.matcher(var0);

                while(true) {
                    CMIChatColor var13;
                    do {
                        if (!var11.find()) {
                            return ChatColor.translateAlternateColorCodes('&', var0);
                        }

                        String var12 = var11.group(2);
                        var13 = getByCustomName(var12.toLowerCase().replace("_", ""));
                    } while(var13 == null);

                    String var14 = var13.getHex();
                    StringBuilder var15 = new StringBuilder("§x");
                    char[] var10;
                    int var9 = (var10 = var14.toCharArray()).length;

                    for(int var8 = 0; var8 < var9; ++var8) {
                        char var16 = var10[var8];
                        var15.append('§').append(var16);
                    }

                    var0 = var0.replace(var11.group(), var15.toString());
                }
            } else {
                return ChatColor.translateAlternateColorCodes('&', var0);
            }
        }
    }

    public static String applyEqualGradient(String var0, List<CMIChatColor> var1) {
        if (var1 != null && !var1.isEmpty()) {
            int var2 = var0.length() / var1.size();
            StringBuilder var3 = new StringBuilder();
            var3.append(((CMIChatColor)var1.get(0)).getFormatedHex(">"));

            for(int var4 = 0; var4 <= var1.size() - 1; ++var4) {
                if (var4 > 0 && var2 > 0) {
                    var3.append(((CMIChatColor)var1.get(var4)).getFormatedHex("<>"));
                }

                for(int var5 = 0; var5 < var2; ++var5) {
                    var3.append(var0.charAt(0));
                    var0 = var0.substring(1);
                }
            }

            var3.append(var0 + ((CMIChatColor)var1.get(var1.size() - 1)).getFormatedHex("<"));
            return var3.toString();
        } else {
            return var0;
        }
    }

    /** @deprecated */
    @Deprecated
    public static String translateAlternateColorCodes(String var0) {
        return translate(var0);
    }

    public static String colorize(String var0) {
        return var0 == null ? null : translate(var0);
    }

    public static String flaten(String var0) {
        return deColorize(var0, true).replace("&", "＆").replace("{#", "{＆#");
    }

    public static String deColorize(String var0) {
        return deColorize(var0, true);
    }

    public static String deColorize(String var0, boolean var1) {
        if (var0 == null) {
            return null;
        } else {
            if (var1) {
                var0 = translate(var0);
            }

            var0 = var0.replace("§", "&");
            if (var0.contains("&x")) {
                Matcher var2 = hexDeColorNamePattern.matcher(var0);

                while(var2.find()) {
                    String var3 = var2.group(3).replace("&", "");
                    CMIChatColor var4 = (CMIChatColor)CUSTOM_BY_HEX.get(var3.toLowerCase());
                    if (var4 != null) {
                        var0 = var0.replace(var2.group(), "{#" + var4.getName().toLowerCase().replace("_", "") + "}");
                    } else {
                        var0 = var0.replace(var2.group(), "{#" + var3 + "}");
                    }
                }
            }

            return var0;
        }
    }

    public static List<String> deColorize(List<String> var0) {
        for(int var1 = 0; var1 < var0.size(); ++var1) {
            var0.set(var1, deColorize((String)var0.get(var1)));
        }

        return var0;
    }

    public static String stripColor(String var0) {
        if (var0 == null) {
            return null;
        } else {
            var0 = translate(var0);
            return ChatColor.stripColor(var0);
        }
    }

    public static String stripHexColor(String var0) {
        var0 = translate(var0);

        Matcher var1;
        String var2;
        for(var1 = hexColorRegexPattern.matcher(var0); var1.find(); var0 = var0.replace(var2, "")) {
            var2 = var1.group();
        }

        if (var0.contains("&x") || var0.contains("§x")) {
            for(var1 = hexDeColorNamePattern.matcher(var0); var1.find(); var0 = var0.replace(var2, "")) {
                var2 = var1.group();
            }
        }

        return var0;
    }

    public static String getLastColors(String var0) {
        if (var0 == null) {
            return null;
        } else {
            var0 = deColorize(var0);
            Matcher var1 = hexColorRegexPatternLast.matcher(var0);
            String var2;
            String[] var3;
            String var4;
            if (var1.find()) {
                var2 = var1.group(0);
                if (var0.endsWith(var2)) {
                    return var2;
                } else {
                    var3 = var0.split(escape(var2), 2);
                    if (var3 == null) {
                        return var2;
                    } else {
                        var4 = getLastColors(var3[1]);
                        return var4 != null && !var4.isEmpty() ? var4 : var2;
                    }
                }
            } else {
                var1 = hexColorNamePatternLast.matcher(var0);
                if (!var1.find()) {
                    return ChatColor.getLastColors(translate(var0));
                } else {
                    var2 = var1.group();
                    if (var0.endsWith(var2)) {
                        return var2;
                    } else {
                        var3 = var0.split(escape(var2), 2);
                        if (var3 == null) {
                            return var2;
                        } else {
                            var4 = getLastColors(var3[1]);
                            return var4 != null && !var4.isEmpty() ? var4 : var2;
                        }
                    }
                }
            }
        }
    }

    public String getColorCode() {
        return this.hexCode != null ? "{#" + this.hexCode + "}" : "&" + this.c;
    }

    public String getBukkitColorCode() {
        return this.hexCode != null ? translate("{#" + this.hexCode + "}") : "§" + this.c;
    }

    public String toString() {
        return this.getBukkitColorCode();
    }

    public char getChar() {
        return this.c;
    }

    public void setChar(char var1) {
        this.c = var1;
    }

    public boolean isColor() {
        return this.color;
    }

    public boolean isFormat() {
        return !this.color && !this.isReset;
    }

    public boolean isReset() {
        return this.isReset;
    }

    public ChatColor getColor() {
        return ChatColor.getByChar(this.getChar());
    }

    public static Set<CMIChatColor> getFormats(String var0) {
        var0 = var0.replace("§", "&");
        HashSet var1 = new HashSet();
        Matcher var2 = formatPattern.matcher(var0);

        while(var2.find()) {
            String var3 = var2.group();
            CMIChatColor var4 = getFormat(var3);
            if (var4 != null && var4.isFormat()) {
                var1.add(var4);
            }
        }

        return var1;
    }

    public static CMIChatColor getFormat(String var0) {
        if (var0 == null) {
            return null;
        } else {
            String var1 = deColorize(var0);
            var0 = var0.replace("§", "&");
            if (var0.length() > 1) {
                String var2 = var0.toLowerCase().replace("_", "");
                CMIChatColor var3 = (CMIChatColor)BY_NAME.get(var2);
                if (var3 != null) {
                    return var3;
                }

                var3 = (CMIChatColor)CUSTOM_BY_NAME.get(var2);
                if (var3 != null) {
                    return var3;
                }
            }

            if (var1.length() > 1 && String.valueOf(var1.charAt(var1.length() - 2)).equalsIgnoreCase("&")) {
                var0 = var0.substring(var0.length() - 1, var0.length());
                Iterator var5 = BY_CHAR.entrySet().iterator();

                while(var5.hasNext()) {
                    Entry var4 = (Entry)var5.next();
                    if (String.valueOf(var4.getKey()).equalsIgnoreCase(var0)) {
                        return ((CMIChatColor)var4.getValue()).isFormat() ? (CMIChatColor)var4.getValue() : null;
                    }
                }
            }

            return null;
        }
    }

    public static CMIChatColor getColor(String var0) {
        if (var0 == null) {
            return null;
        } else {
            String var1 = deColorize(var0);
            if (var1.contains("{#")) {
                Matcher var2 = hexColorRegexPatternLast.matcher(var1);
                if (var2.find()) {
                    return new CMIChatColor(var2.group(2));
                }

                var2 = hexColorNamePatternLast.matcher(var1);
                if (var2.find()) {
                    return getByCustomName(var2.group(2));
                }
            }

            var0 = deColorize(var0).replace("&", "");
            if (var0.length() > 1) {
                String var4 = var0.toLowerCase().replace("_", "");
                CMIChatColor var3 = (CMIChatColor)BY_NAME.get(var4);
                if (var3 != null) {
                    return var3;
                }

                var3 = (CMIChatColor)CUSTOM_BY_NAME.get(var4);
                if (var3 != null) {
                    return var3;
                }
            }

            if (var1.length() > 1 && String.valueOf(var1.charAt(var1.length() - 2)).equalsIgnoreCase("&")) {
                var0 = var0.substring(var0.length() - 1, var0.length());
                Iterator var6 = BY_CHAR.entrySet().iterator();

                while(var6.hasNext()) {
                    Entry var5 = (Entry)var6.next();
                    if (String.valueOf(var5.getKey()).equalsIgnoreCase(var0)) {
                        return (CMIChatColor)var5.getValue();
                    }
                }
            }

            return null;
        }
    }

    public static CMIChatColor getRandomColor() {
        ArrayList var0 = new ArrayList();
        Iterator var2 = BY_NAME.entrySet().iterator();

        while(var2.hasNext()) {
            Entry var1 = (Entry)var2.next();
            if (((CMIChatColor)var1.getValue()).isColor()) {
                var0.add((CMIChatColor)var1.getValue());
            }
        }

        Collections.shuffle(var0);
        return (CMIChatColor)var0.get(0);
    }

    public Pattern getPattern() {
        return this.pattern;
    }

    public org.bukkit.Color getRGBColor() {
        return this.blueChannel < 0 ? null : org.bukkit.Color.fromRGB(this.redChannel, this.greenChannel, this.blueChannel);
    }

    public String getHex() {
        return this.hexCode;
    }

    public String getFormatedHex() {
        return this.getFormatedHex((String)null);
    }

    public String getFormatedHex(String var1) {
        return "{#" + this.hexCode + (var1 == null ? "" : var1) + "}";
    }

    public String getName() {
        return this.name;
    }

    public String getCleanName() {
        return this.name.replace("_", "");
    }

    public static CMIChatColor getByCustomName(String var0) {
        if (var0.equalsIgnoreCase("random")) {
            ArrayList var1 = new ArrayList(CUSTOM_BY_NAME.values());
            int var2 = (new Random()).nextInt(var1.size());
            return (CMIChatColor)var1.get(var2);
        } else {
            return (CMIChatColor)CUSTOM_BY_NAME.get(var0.toLowerCase().replace("_", ""));
        }
    }

    public static CMIChatColor getByHex(String var0) {
        if (var0.startsWith("{#")) {
            var0 = var0.substring("{#".length());
        }

        if (var0.endsWith("}")) {
            var0 = var0.substring(0, var0.length() - "}".length());
        }

        return (CMIChatColor)CUSTOM_BY_HEX.get(var0.toLowerCase().replace("_", ""));
    }

    public static Map<String, CMIChatColor> getByName() {
        return BY_NAME;
    }

    public static Map<String, CMIChatColor> getByCustomName() {
        return CUSTOM_BY_NAME;
    }

    public static String getHexFromCoord(int var0, int var1) {
        var0 = var0 < 0 ? 0 : (var0 > 255 ? 255 : var0);
        var1 = var1 < 0 ? 0 : (var1 > 255 ? 255 : var1);
        int var2 = (int)(255.0D - (double)(var1 * 255) * (1.0D + Math.sin(6.3D * (double)var0)) / 2.0D);
        int var3 = (int)(255.0D - (double)(var1 * 255) * (1.0D + Math.cos(6.3D * (double)var0)) / 2.0D);
        int var4 = (int)(255.0D - (double)(var1 * 255) * (1.0D - Math.sin(6.3D * (double)var0)) / 2.0D);
        StringBuilder var5 = (new StringBuilder()).append(Integer.toHexString((var4 << 16) + (var3 << 8) + var2 & 16777215));

        while(var5.length() < 6) {
            var5.append("0" + var5);
        }

        return "#" + var5.toString();
    }

    public static String getHexRedGreenByPercent(int var0, int var1) {
        float var2 = (float)var0 * 33.0F / 100.0F / 100.0F;
        Color var3 = Color.getHSBColor(var2, 1.0F, 1.0F);
        StringBuilder var4 = (new StringBuilder()).append(Integer.toHexString((var3.getRed() << 16) + (var3.getGreen() << 8) + var3.getBlue() & 16777215));

        while(var4.length() < 6) {
            var4.append("0" + var4);
        }

        return "#" + var4.toString();
    }

    public int getRed() {
        return this.redChannel;
    }

    public int getGreen() {
        return this.greenChannel;
    }

    public int getBlue() {
        return this.blueChannel;
    }

    public static CMIChatColor getClosest(String var0) {
        if (var0.startsWith("#")) {
            var0 = var0.substring(1);
        }

        CMIChatColor var1 = (CMIChatColor)CUSTOM_BY_RGB.get(var0);
        if (var1 != null) {
            return var1;
        } else {
            Color var2 = null;

            try {
                var2 = new Color(Integer.valueOf(var0.substring(0, 2), 16), Integer.valueOf(var0.substring(2, 4), 16), Integer.valueOf(var0.substring(4, 6), 16));
            } catch (Throwable var16) {
                return null;
            }

            double var3 = 1.7976931348623157E308D;
            Iterator var6 = CUSTOM_BY_HEX.entrySet().iterator();

            while(var6.hasNext()) {
                Entry var5 = (Entry)var6.next();
                Color var7 = new Color(Integer.valueOf(((CMIChatColor)var5.getValue()).hexCode.substring(0, 2), 16), Integer.valueOf(((CMIChatColor)var5.getValue()).hexCode.substring(2, 4), 16), Integer.valueOf(((CMIChatColor)var5.getValue()).hexCode.substring(4, 6), 16));
                int var8 = var7.getRed();
                int var9 = var2.getRed();
                int var10 = var8 + var9 >> 1;
                int var11 = var8 - var9;
                int var12 = var7.getGreen() - var2.getGreen();
                int var13 = var7.getBlue() - var2.getBlue();
                double var14 = Math.sqrt((double)(((512 + var10) * var11 * var11 >> 8) + 4 * var12 * var12 + ((767 - var10) * var13 * var13 >> 8)));
                if (var14 < var3) {
                    var1 = (CMIChatColor)var5.getValue();
                    var3 = var14;
                }
            }

            if (var1 != null) {
                CUSTOM_BY_RGB.put(var0, var1);
                return var1;
            } else {
                CUSTOM_BY_RGB.put(var0, (CMIChatColor) null);
                return null;
            }
        }
    }

    public CMIChatColor mixColors(CMIChatColor var1, double var2) {
        return mixColors(this, var1, var2);
    }

    public static CMIChatColor mixColors(CMIChatColor var0, CMIChatColor var1, double var2) {
        var2 /= 100.0D;
        double var4 = 1.0D - var2;
        int var6 = (int)((double)var1.getRed() * var2 + (double)var0.getRed() * var4);
        int var7 = (int)((double)var1.getGreen() * var2 + (double)var0.getGreen() * var4);
        int var8 = (int)((double)var1.getBlue() * var2 + (double)var0.getBlue() * var4);
        String var9 = String.format("#%02x%02x%02x", var6, var7, var8);
        return new CMIChatColor(var9);
    }
}
