package ddggddess.ddggddess.event;

import org.bukkit.Bukkit;

public enum Version {
    v1_7_R1,
    v1_7_R2,
    v1_7_R3,
    v1_7_R4,
    v1_8_R1,
    v1_8_R2,
    v1_8_R3,
    v1_9_R1,
    v1_9_R2,
    v1_10_R1,
    v1_11_R1,
    v1_12_R1,
    v1_13_R1,
    v1_13_R2,
    v1_13_R3,
    v1_14_R1,
    v1_14_R2,
    v1_15_R1,
    v1_15_R2,
    v1_16_R1,
    v1_16_R2,
    v1_16_R3,
    v1_17_R1,
    v1_17_R2,
    v1_18_R1,
    v1_18_R2,
    v1_19_R1,
    v1_19_R2,
    v1_20_R1,
    v1_20_R2;

    private Integer value;
    private String shortVersion;
    private static Version current = null;
    private static MinecraftPlatform platform = null;

    static {
        getCurrent();
    }

    private Version() {
        try {
            this.value = Integer.valueOf(this.name().replaceAll("[^\\d.]", ""));
        } catch (Exception var4) {
        }

        this.shortVersion = this.name().substring(0, this.name().length() - 3);
    }

    public Integer getValue() {
        return this.value;
    }

    public String getShortVersion() {
        return this.shortVersion;
    }

    public String getShortFormated() {
        return this.shortVersion.replace("v", "").replace("_", ".") + ".x";
    }

    public static boolean isPaper() {
        return !getPlatform().equals(MinecraftPlatform.craftbukkit) && !getPlatform().equals(MinecraftPlatform.spigot);
    }

    public static boolean isSpigot() {
        return !getPlatform().equals(MinecraftPlatform.craftbukkit);
    }

    public static MinecraftPlatform getPlatform() {
        if (platform != null) {
            return platform;
        } else {
            try {
                Class.forName("com.destroystokyo.paper.PaperConfig");
                platform = MinecraftPlatform.paper;
            } catch (ClassNotFoundException var3) {
                try {
                    Class.forName("org.spigotmc.SpigotConfig");
                    platform = MinecraftPlatform.spigot;
                } catch (ClassNotFoundException var2) {
                    platform = MinecraftPlatform.craftbukkit;
                }
            }

            return platform;
        }
    }

    public static Version getCurrent() {
        if (current != null) {
            return current;
        } else {
            String[] var0 = Bukkit.getServer().getClass().getPackage().getName().split("\\.");
            String var1 = var0[var0.length - 1];
            Version[] var5;
            int var4 = (var5 = values()).length;

            for(int var3 = 0; var3 < var4; ++var3) {
                Version var2 = var5[var3];
                if (var2.name().equalsIgnoreCase(var1)) {
                    current = var2;
                    break;
                }
            }

            return current == null ? v1_13_R2 : current;
        }
    }

    public boolean isLower(Version var1) {
        return this.getValue() < var1.getValue();
    }

    public boolean isHigher(Version var1) {
        return this.getValue() > var1.getValue();
    }

    public boolean isEqualOrLower(Version var1) {
        return this.getValue() <= var1.getValue();
    }

    public boolean isEqualOrHigher(Version var1) {
        return this.getValue() >= var1.getValue();
    }

    public static boolean isCurrentEqualOrHigher(Version var0) {
        return current.getValue() >= var0.getValue();
    }

    public static boolean isCurrentHigher(Version var0) {
        return current.getValue() > var0.getValue();
    }

    public static boolean isCurrentLower(Version var0) {
        return current.getValue() < var0.getValue();
    }

    public static boolean isCurrentEqualOrLower(Version var0) {
        return current.getValue() <= var0.getValue();
    }

    public static boolean isCurrentEqual(Version var0) {
        return current.getValue() == var0.getValue();
    }
}

