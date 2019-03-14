package ru.lnti.elterionrpg.rpginventory.Capability;

import ru.lnti.elterionrpg.rpginventory.RpgCustomInventory;

public interface ICAPRpgCustomInventory {
   
	public void copyInventory(ICAPRpgCustomInventory inventory);

    public RpgCustomInventory getInventory();
}
