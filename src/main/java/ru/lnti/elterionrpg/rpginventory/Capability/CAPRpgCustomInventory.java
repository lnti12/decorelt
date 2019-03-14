package ru.lnti.elterionrpg.rpginventory.Capability;

import ru.lnti.elterionrpg.rpginventory.RpgCustomInventory;

public class CAPRpgCustomInventory implements ICAPRpgCustomInventory {

    //��������� ������, ��� ���������� � ���������� ICAPCustomInventory

    //������� ������ ������ ���������. �� ����� ��������� � ���� ���'�
    public final RpgCustomInventory inventory = new RpgCustomInventory();

    /**
     * �����, ������� ���������� ������ ��������� inventory
     */
    public RpgCustomInventory getInventory(){

        return this.inventory;
    }

    /**
     * �����, ��� ����������� ���������� �� ������� ���������, �������� ��� ������������
     */
    @Override
    public void copyInventory(ICAPRpgCustomInventory inventory) {

        this.inventory.copy(inventory.getInventory());
    }

}
