package ru.lnti.elterionrpg.rpginventory.Capability;

import ru.lnti.elterionrpg.rpginventory.RpgCustomInventory;

public class CAPRpgCustomInventory implements ICAPRpgCustomInventory {

    //Реализуем методы, что определены в интерфейсе ICAPCustomInventory

    //Создаем обьект нашего инвентаря. Он будет храниться в этой КАП'е
    public final RpgCustomInventory inventory = new RpgCustomInventory();

    /**
     * Метод, который возвращает обьект инвентаря inventory
     */
    public RpgCustomInventory getInventory(){

        return this.inventory;
    }

    /**
     * Метод, для копировании информации из другого инвентаря, например при клонировании
     */
    @Override
    public void copyInventory(ICAPRpgCustomInventory inventory) {

        this.inventory.copy(inventory.getInventory());
    }

}
