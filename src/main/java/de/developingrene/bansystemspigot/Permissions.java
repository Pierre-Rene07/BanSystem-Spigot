package de.developingrene.bansystemspigot;

public enum Permissions {

    IGNORE_BAN("bansystem.admin.ignore");

    String perm;
    Permissions(String s) {
        this.perm = s;
    }

    String getPerm(){
        return this.perm;
    }
}
