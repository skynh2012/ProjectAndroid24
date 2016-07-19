package com.niit.duyanh.ketquaxoso.models;

/**
 * Created by DuyAnh on 19/07/2016.
 */
public class SoiCau {
    private String avatarSoiCau;

    private String titleSoiCau;

    private String iconSoiCau;

    public SoiCau(String avatarSoiCau, String titleSoiCau, String iconSoiCau) {
        this.avatarSoiCau = avatarSoiCau;
        this.titleSoiCau = titleSoiCau;
        this.iconSoiCau = iconSoiCau;
    }

    public SoiCau() {
    }

    public String getAvatarSoiCau() {
        return avatarSoiCau;
    }

    public void setAvatarSoiCau(String avatarSoiCau) {
        this.avatarSoiCau = avatarSoiCau;
    }

    public String getTitleSoiCau() {
        return titleSoiCau;
    }

    public void setTitleSoiCau(String titleSoiCau) {
        this.titleSoiCau = titleSoiCau;
    }

    public String getIconSoiCau() {
        return iconSoiCau;
    }

    public void setIconSoiCau(String iconSoiCau) {
        this.iconSoiCau = iconSoiCau;
    }
}
