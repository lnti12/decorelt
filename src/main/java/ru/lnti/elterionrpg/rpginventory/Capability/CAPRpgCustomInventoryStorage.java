package ru.lnti.elterionrpg.rpginventory.Capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CAPRpgCustomInventoryStorage implements IStorage<ICAPRpgCustomInventory> {

    //Сохранение информации (т.е. предметов, что лежать в инвентаре) с помощью writeToNBT

    @Override
    public NBTBase writeNBT(Capability<ICAPRpgCustomInventory> capability, ICAPRpgCustomInventory instance, EnumFacing side) {

        NBTTagCompound properties = new NBTTagCompound();
        //Вызываем метод writeToNBT из инвентаря и записываем инфу о инвентаре с его помощью в тэг
        instance.getInventory().writeToNBT(properties);
        return properties;
    }

    //Чтение информации (т.е. предметов, что лежать в инвентаре) и добавление их в инвентарь с помощью readFromNBT
    @Override
    public void readNBT(Capability<ICAPRpgCustomInventory> capability, ICAPRpgCustomInventory instance, EnumFacing side, NBTBase nbt) {

        NBTTagCompound properties = (NBTTagCompound)nbt;
        //Вызываем метод readFromNBT из инвентаря и кладем в него(инв.) стаки которые хранились в тэге
        instance.getInventory().readFromNBT(properties);
    }

}
