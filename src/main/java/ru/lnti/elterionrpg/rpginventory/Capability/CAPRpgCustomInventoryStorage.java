package ru.lnti.elterionrpg.rpginventory.Capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CAPRpgCustomInventoryStorage implements IStorage<ICAPRpgCustomInventory> {

    //���������� ���������� (�.�. ���������, ��� ������ � ���������) � ������� writeToNBT

    @Override
    public NBTBase writeNBT(Capability<ICAPRpgCustomInventory> capability, ICAPRpgCustomInventory instance, EnumFacing side) {

        NBTTagCompound properties = new NBTTagCompound();
        //�������� ����� writeToNBT �� ��������� � ���������� ���� � ��������� � ��� ������� � ���
        instance.getInventory().writeToNBT(properties);
        return properties;
    }

    //������ ���������� (�.�. ���������, ��� ������ � ���������) � ���������� �� � ��������� � ������� readFromNBT
    @Override
    public void readNBT(Capability<ICAPRpgCustomInventory> capability, ICAPRpgCustomInventory instance, EnumFacing side, NBTBase nbt) {

        NBTTagCompound properties = (NBTTagCompound)nbt;
        //�������� ����� readFromNBT �� ��������� � ������ � ����(���.) ����� ������� ��������� � ����
        instance.getInventory().readFromNBT(properties);
    }

}
