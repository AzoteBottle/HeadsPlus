package io.github.thatsmusic99.headsplus.util;

public enum AdventCManager {

    FIRST(1, 10, "&7[&9Present&7]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjU2MTJkYzdiODZkNzFhZmMxMTk3MzAxYzE1ZmQ5NzllOWYzOWU3YjFmNDFkOGYxZWJkZjgxMTU1NzZlMmUifX19", "&2[&a1st December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2I3ZTU4OTEzOGJiOGU3Y2FiYWJjMjNiNjJkMzEyYTM2OWNjMzRiN2Y0Y2E0MTU0ZDg3YjJkZTEwMWE4YzRkIn19fQ"),
    SECOND(2, 11, "&7[&cRed Bauble&7]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODg0ZTkyNDg3YzY3NDk5OTViNzk3MzdiOGE5ZWI0YzQzOTU0Nzk3YTZkZDZjZDliNGVmY2UxN2NmNDc1ODQ2In19fQ", "&4[&c2nd December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTM4N2YwNWY4NTM0MWNlM2NmNGIzNWUzYTNiMzljNGE2N2Q5NmEyMjBlMzk1NDM5YzM1ZjQ4YTM2OWQzNWZhIn19fQ"),
    THIRD(3, 12, "&7[&cSanta!&7]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTRlNDI0YjE2NzZmZWVjM2EzZjhlYmFkZTllN2Q2YTZmNzFmNzc1NmE4NjlmMzZmN2RmMGZjMTgyZDQzNmUifX19", "&2[&a3rd December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzQ3ZmRhNTk0NzQxOGY3OTE0NzVhMWE0ZGU0YTQ3ZDUzOWZhNmJkNWY0MjhhM2UzZDQ4Yjg2MjRhZDE1NTcifX19"),
    FOURTH(4, 13, "&7[&fSnowglobe&7]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg2MTU2ZDdmMjEzMjY2OWMzNjdhYjg5NTIzYzJlMWI5ODY2ZTQwYjJiODkxMzkzNzQ0NjU3ZjFjMzU1In19fQ", "&4[&c4th December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2E0ZTdjZGQzZjg3YzNmNDRlMWE2ZGY3OGYxZmZiNzU0MmEyYjBlMzM2YThiN2UyN2UxMWE5ZTY4YTdmODk5OSJ9fX0"),
    FIFTH(5, 14, "", "", "&2[&a5th December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTY1ODVkNzg0MWQwNWY4OTM3NTYzMTU2NGZjYTc3NGIzZWRlZmU4NmFmMmI2YWUzOWYzYmFlY2ViYjU0OSJ9fX0"),
    SIXTH(6, 15, "", "", "&4[&c6th December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWU1NWI0YzM2NTMxOTNiMmJhNjgzOTJlMjgwYWQ3MjE0N2Q4ZWFiMWIxYTQ4Y2Y5N2ZlOWFjZjQyNDI2MzgifX19"),
    SEVENTH(7, 16, "", "", "&2[&a7th December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGU1YzRlNTJkZTNhMzhjZDg3YmNmZjQ4NjY4YTU1Y2JiYWU1MDZjOWE5N2U1ZDhkZjZmNTk3NWU3NDQyNyJ9fX0"),
    EIGHTH(8, 19, "", "", "&4[&c8th December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjEwMzM2NjdjZmYzYzdmZDkxZmM5OTU1MmE0MjgxZTc3ZjhhOWRiYTRjNzlkNzA0MWIyNDdkZDJjYThhMyJ9fX0"),
    NINTH(9, 20, "", "", "&2[&a9th December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTU5YWRhMzE2MjNhODdmOGQ0YTBmOTkzNzBhYjYwMTAzZGJmZmYzNWE1OTE3ODk5OTg0ZTBhMGZiODlkZmZlIn19fQ"),
    TENTH(10, 21, "", "", "&4[&c10th December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGE5YTJiNWExOTZmZDBlNzIxZWU1MTlmZmM0YmVmNTFhMGFhY2I5OGExNDY0NmRkYmFjN2ZiNWI3ZjI3ZjIifX19"),
    ELEVENTH(11, 22, "", "", "&2[&a11th December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjE1ZGQwNDZlMGQ1MDk0OTQyYjgwN2IzYTNhNzU5OWIyMjc4ODc2NjcxMzcxODNjZThmYmYxOTBjZWMyNjEifX19"),
    TWELFTH(12, 23, "", "", "&4[&c12th December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGI5ZWQxYTQzYjMyNGY4NWFlNTlkN2ZhZmMzNGE5MTFjNWJhYmM1ZWRkZmZjOTZiZWJiYWNjMzVjYjlhZjc2ZSJ9fX0"),
    THIRTEENTH(13, 24, "", "", "&2[&a13th December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzJkZDNlOGJlYjc4YzJhMzVlNmE5NmE0YzY3N2NjZmFlNDI2OTdiMTZhZmE4ZjUyYmU2OGI3YTQzMjRjNjZjIn19fQ"),
    FOURTEENTH(14, 25, "", "", "&4[&c14th December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzJjOTZiNTU3MDk3ZmVhOGQ1OGFhMWE2OGU2NGRjMTgxNjgwM2EyZjE5N2M0NzZiZWFlZDQxNDRlODVjOCJ9fX0"),
    FIFTEENTH(15, 28, "", "", "&2[&a15th December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWM2YThhMzgwM2Q0OGI5ZTJkMjEyNTU5OTNhNTU4ZWYzZWY4YTc0NDEzMjExZjI0MjcxMWQ3MDI2YTczOGQ0In19fQ"),
    SIXTEENTH(16, 29, "", "", "&4[&c16th December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWI4MDdjNGQ5ZmMzZWNhZmI2Y2NkYjY1NjRjYTA3MzE4NDE0NGNkZTU2ZDU2NzEyNjdlNDY2NzdmNjY0NTcifX19"),
    SEVENTEENTH(17, 30, "", "", "&2[&a17th December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjQ1NzMxZDc2MDViODk1MzcyZDQxZjc3OTE0NTVhOTMzNTBhYjZmNzRkNTllNmQ4NTgyNjY4ZWJjYmE3In19fQ"),
    EIGHTEENTH(18, 31, "", "", "&4[&c18th December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjcyZTQ2NzNhNTMyNjhhZmMzNmQ3YTMyN2RjMjU3YjkyN2E4MjIxOGFlMTU1OTZmMTNjNjJiNzAzN2RjZiJ9fX0"),
    NINETEENTH(19, 32, "", "", "&2[&a19th December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjcyY2FkMzc4NmZhNGM4M2ZmYWI5MTkyOWRmZGZjZGM1NjhlNDNkMjIxNzUxNjY1YTdlMzA5NDg5Mjk1MDU1In19fQ"),
    TWENTIETH(20, 33, "", "", "&4[&c20th December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWU1MjE5YWJlMmNmNTE4NGVlNWE1ZTk1MTEyN2E3ZjdkM2RlZTM5OWQ4YTQ2ODIyZjYzNzk0ZjE2NWUifX19"),
    TWENTY_FIRST(21, 34, "", "", "&2[&a21st December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWNhY2ZkYzc3OTUyYzdmMWFmYWNiYzVhYzY1Mzc2ZTQ5OGJkYTUzNmY0ZjYzOWZmZTYxNGQyODg5OGU0YTZhZCJ9fX0"),
    TWENTY_SECOND(22, 39, "", "", "&4[&c22nd December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODA5MWI3ZmJkYzRmY2FlNWRmYTU5Yjc4NGUxMjJjZWI1YzJmZTUxYmFiYjVmZGNmZmE5ZGVhYmQ3MTA1In19fQ"),
    TWENTY_THIRD(23, 40, "", "", "&2[&a23rd December&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTAxYjk5NmM1YWU1YTA1OGQxYTFkN2M1MzBjYzhmNWFjMTNlM2I0MWRlMjNkNjNkY2YzZWFmNzM2MGIzM2YifX19"),
    TWENTY_FOURTH(24, 41, "", "", "&4[&c24th December&4]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTJjNjFiYTFkZmZhZDNiMmQ0YTI1N2E5MWZlN2VhOTg0NWIwNjQ1ZDdiOGFmMGNiNWJlOTdlNmVkNDEyZiJ9fX0"),
    TWENTY_FIFTH(25, 43, "", "", "&2[&a&l?&2]", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGM1YWQ0M2NhODM2YTdlNTc3MmY4YmViNDJhZDBmZTFhYjNkZjRkYmExMWI4YWI4YjA4YmZhM2UxMzE3NmMifX19");

    public int date;
    public int place;
    public String name;
    public String texture;
    public String wName;
    public String wTexture;

    AdventCManager(int i, int place, String s, String sr, String wName, String wTexture) {
        date = i;
        this.place = place;
        name = s;
        texture = sr;
        this.wName = wName;
        this.wTexture = wTexture;
    }

    
}