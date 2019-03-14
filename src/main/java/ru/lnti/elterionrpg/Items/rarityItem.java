package ru.lnti.elterionrpg.Items;

public enum rarityItem {

    standart,rare,legendary;     
	
    public static rarityItem getByMeta(int meta) {
        for (rarityItem type : values()) {
            if (type.ordinal() == meta)
                return type;
        }
        return null;
    }
	
}
