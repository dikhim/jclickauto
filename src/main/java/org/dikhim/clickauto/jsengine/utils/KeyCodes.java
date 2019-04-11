package org.dikhim.clickauto.jsengine.utils;


import java.util.ArrayList;
import java.util.List;

import static java.awt.event.KeyEvent.*;

/**
 * Created by dikobraz on 25.03.17.
 */


@SuppressWarnings({"SpellCheckingInspection", "unused"})
public class KeyCodes {
    private static List<KeyCode> codes;

    static {
        codes = new ArrayList<>();
        codes.add(new KeyCode("0", 0, VK_0, 0));
        codes.add(new KeyCode("1", 0_1, VK_1, 1));
        codes.add(new KeyCode("2", 0, VK_2, 2));
        codes.add(new KeyCode("3", 0, VK_3, 3));
        codes.add(new KeyCode("4", 0, VK_4, 4));
        codes.add(new KeyCode("5", 0, VK_5, 5));
        codes.add(new KeyCode("6", 0, VK_6, 6));
        codes.add(new KeyCode("7", 0, VK_7, 7));
        codes.add(new KeyCode("8", 0, VK_8, 8));
        codes.add(new KeyCode("9", 0, VK_9, 9));
        codes.add(new KeyCode("A", 0, VK_A, 10));
        codes.add(new KeyCode("B", 0, VK_B, 11));
        codes.add(new KeyCode("C", 0, VK_C, 12));
        codes.add(new KeyCode("D", 0, VK_D, 13));
        codes.add(new KeyCode("E", 0, VK_E, 14));
        codes.add(new KeyCode("F", 0, VK_F, 15));
        codes.add(new KeyCode("G", 0, VK_G, 16));
        codes.add(new KeyCode("H", 0, VK_H, 17));
        codes.add(new KeyCode("J", 0, VK_J, 18));
        codes.add(new KeyCode("I", 0, VK_I, 19));
        codes.add(new KeyCode("K", 0, VK_K, 20));
        codes.add(new KeyCode("L", 0, VK_L, 21));
        codes.add(new KeyCode("M", 0, VK_M, 22));
        codes.add(new KeyCode("N", 0, VK_N, 23));
        codes.add(new KeyCode("O", 0, VK_O, 24));
        codes.add(new KeyCode("P", 0, VK_P, 25));
        codes.add(new KeyCode("Q", 0, VK_Q, 26));
        codes.add(new KeyCode("R", 0, VK_R, 27));
        codes.add(new KeyCode("S", 0, VK_S, 28));
        codes.add(new KeyCode("T", 0, VK_T, 29));
        codes.add(new KeyCode("U", 0, VK_U, 30));
        codes.add(new KeyCode("V", 0, VK_V, 31));
        codes.add(new KeyCode("W", 0, VK_W, 32));
        codes.add(new KeyCode("X", 0, VK_X, 33));
        codes.add(new KeyCode("Y", 0, VK_Y, 34));
        codes.add(new KeyCode("Z", 0, VK_Z, 35));

        codes.add(new KeyCode("ENTER", 0, VK_ENTER, 36));
        codes.add(new KeyCode("BACKSPACE", 0, VK_BACK_SPACE, 37));
        codes.add(new KeyCode("TAB", 0, VK_TAB, 38));

        //return VK_CANCEL));
        //return VK_CLEAR));

        codes.add(new KeyCode("SHIFT", 0, VK_SHIFT, 39));
        codes.add(new KeyCode("SHIFT", 0, VK_SHIFT, 40));
        codes.add(new KeyCode("CONTROL", 0, VK_CONTROL, 41));
        codes.add(new KeyCode("CONTROL", 0, VK_CONTROL, 42));
        codes.add(new KeyCode("ALT", 0, VK_ALT, 43));
        codes.add(new KeyCode("ALT", 0, VK_ALT, 44));
        codes.add(new KeyCode("PAUSE", 0, VK_PAUSE, 45));
        codes.add(new KeyCode("CAPS_LOCK", 0, VK_CAPS_LOCK, 46));
        codes.add(new KeyCode("ESCAPE", 0, VK_ESCAPE, 47));
        codes.add(new KeyCode("SPACE", 0, VK_SPACE, 48));
        codes.add(new KeyCode("PAGE_UP", 0, VK_PAGE_UP, 49));
        codes.add(new KeyCode("PAGE_DOWN", 0, VK_PAGE_DOWN, 50));
        codes.add(new KeyCode("END", 0, VK_END, 51));
        codes.add(new KeyCode("HOME", 0, VK_HOME, 52));

        codes.add(new KeyCode("LEFT", 0, VK_LEFT, 53));
        codes.add(new KeyCode("RIGHT", 0, VK_RIGHT, 54));
        codes.add(new KeyCode("UP", 0, VK_UP, 55));
        codes.add(new KeyCode("DOWN", 0, VK_DOWN, 56));
        codes.add(new KeyCode(",", 0, VK_COMMA, 57));
        codes.add(new KeyCode("-", 0, VK_MINUS, 58));
        codes.add(new KeyCode(".", 0, VK_PERIOD, 59));
        codes.add(new KeyCode("/", 0, VK_SLASH, 60));

        codes.add(new KeyCode(";", 0, VK_SEMICOLON, 61));
        codes.add(new KeyCode("=", 0, VK_EQUALS, 62));

        codes.add(new KeyCode("[", 0, VK_OPEN_BRACKET, 63));
        codes.add(new KeyCode("]", 0, VK_CLOSE_BRACKET, 64));
        codes.add(new KeyCode("\\", 0, VK_BACK_SLASH, 65));

        // Numpad
        codes.add(new KeyCode("NUM_LOCK", 0, VK_NUM_LOCK, 66));
        codes.add(new KeyCode("NUMPAD0", 0, VK_NUMPAD0, 67));
        codes.add(new KeyCode("NUMPAD1", 0, VK_NUMPAD1, 68));
        codes.add(new KeyCode("NUMPAD2", 0, VK_NUMPAD2, 69));
        codes.add(new KeyCode("NUMPAD3", 0, VK_NUMPAD3, 70));
        codes.add(new KeyCode("NUMPAD4", 0, VK_NUMPAD4, 71));
        codes.add(new KeyCode("NUMPAD5", 0, VK_NUMPAD5, 72));
        codes.add(new KeyCode("NUMPAD6", 0, VK_NUMPAD6, 73));
        codes.add(new KeyCode("NUMPAD7", 0, VK_NUMPAD7, 74));
        codes.add(new KeyCode("NUMPAD8", 0, VK_NUMPAD8, 75));
        codes.add(new KeyCode("NUMPAD9", 0, VK_NUMPAD9, 76));

        codes.add(new KeyCode("MULTIPLY", 0, VK_MULTIPLY, 77));
        codes.add(new KeyCode("DIVIDE", 0, VK_DIVIDE, 78));

        codes.add(new KeyCode("F1", 0, VK_F1, 79));
        codes.add(new KeyCode("F2", 0, VK_F2, 80));
        codes.add(new KeyCode("F3", 0, VK_F3, 81));
        codes.add(new KeyCode("F4", 0, VK_F4, 82));
        codes.add(new KeyCode("F5", 0, VK_F5, 83));
        codes.add(new KeyCode("F6", 0, VK_F6, 84));
        codes.add(new KeyCode("F7", 0, VK_F7, 85));
        codes.add(new KeyCode("F8", 0, VK_F8, 86));
        codes.add(new KeyCode("F9", 0, VK_F9, 87));
        codes.add(new KeyCode("F10", 0, VK_F10, 88));
        codes.add(new KeyCode("F11", 0, VK_F11, 89));
        codes.add(new KeyCode("F12", 0, VK_F12, 90));
        codes.add(new KeyCode("F13", 0, VK_F13, 91));
        codes.add(new KeyCode("F14", 0, VK_F14, 92));
        codes.add(new KeyCode("F15", 0, VK_F15, 93));
        codes.add(new KeyCode("F16", 0, VK_F16, 94));
        codes.add(new KeyCode("F17", 0, VK_F17, 95));
        codes.add(new KeyCode("F18", 0, VK_F18, 96));
        codes.add(new KeyCode("F19", 0, VK_F19, 97));
        codes.add(new KeyCode("F20", 0, VK_F20, 98));
        codes.add(new KeyCode("F21", 0, VK_F21, 99));
        codes.add(new KeyCode("F22", 0, VK_F22, 100));
        codes.add(new KeyCode("F23", 0, VK_F23, 101));
        codes.add(new KeyCode("F24", 0, VK_F24, 102));


        codes.add(new KeyCode("PRINTSCREEN", 0, VK_PRINTSCREEN, 103));
        codes.add(new KeyCode("INSERT", 0, VK_INSERT, 104));
        //return VK_HELP));
        //return VK_META));
        codes.add(new KeyCode("`", 0, VK_BACK_QUOTE, 105));
        codes.add(new KeyCode("'", 0, VK_QUOTE, 106));
        codes.add(new KeyCode("DELETE", 0, VK_DELETE, 107));
        codes.add(new KeyCode("ALT_GR", 0, VK_ALT, 108));


    }
    private static KeyCode getByName(String name){
        for(KeyCode kc:codes){
            if(kc.getName().equals(name))return kc;
        }
        return null;
    }
    private static KeyCode getByNativeCode(int code){
        for(KeyCode kc:codes){
            if(kc.getNativeCode() ==code)return kc;
        }
        return null;
    }
    private static KeyCode getByEventCode(int code){
        for(KeyCode kc:codes){
            if(kc.getEventCode() ==code)return kc;
        }
        return null;
    }

    private static KeyCode getByUselessCode(int code){
        for(KeyCode kc:codes){
            if(kc.getUselessCode() ==code)return kc;
        }
        return null;
    }

    public static String getNameByNativeCode(int code){
    	KeyCode k = getByNativeCode(code);
    	if(k==null)return "";
    	return k.getName();
    }
    public static String getNameByEventCode(int code){
        KeyCode k = getByEventCode(code);
        if(k==null)return "";
    	return k.getName();
    }
    public static int getNativeCodeByName(String name){
        KeyCode k = getByName(name);
        if(k==null)return -1;
        return k.getNativeCode();
    }
    public static int getNativeCodeByEventCode(int code){
        KeyCode k = getByEventCode(code);
        if(k==null)return -1;
        return k.getNativeCode();
    }
    public static int getEventCodeByNativeCode(int code){
        KeyCode k = getByNativeCode(code);
        if(k==null)return -1;
        return k.getEventCode();
    }
    public static int getEventCodeByName(String name){
        KeyCode k = getByName(name);
        if(k==null)return -1;
        return k.getEventCode();
    }

    public static int getUslessCodeByName(String name) {
        KeyCode k = getByName(name);
        if(k==null)return -1;
        return k.getUselessCode();
    }

    public static int getEventCodeByUselessCode(int code){
        KeyCode k = getByUselessCode(code);
        if(k==null)return -1;
        return k.getEventCode();
    }

    public static String getNameByUselessCode(int code){
        KeyCode k = getByUselessCode(code);
        if(k==null)return "";
        return k.getName();
    }

    public static List<KeyCode> getCodes() {
        return codes;
    }
}

