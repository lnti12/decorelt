package ru.lnti.elterionrpg.rpginventory.container;


import javax.annotation.Nullable;

import ru.lnti.elterionrpg.rpginventory.RpgCustomInventory;
import ru.lnti.elterionrpg.slot.BaubleSlot;
import ru.lnti.elterionrpg.slot.EnumBaubleType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.entity.EntityLiving;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RpgContainerCustomInv  extends Container {

    private static final EntityEquipmentSlot[] VALID_EQUIPMENT_SLOTS = new EntityEquipmentSlot[] {EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET, EntityEquipmentSlot.OFFHAND};

    private final EntityPlayer thePlayer;
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 2);
    public InventoryCraftResult craftResult = new InventoryCraftResult();

    
    public RpgContainerCustomInv(InventoryPlayer playerInventory, RpgCustomInventory cInventory, EntityPlayer player) {
    	
        this.addSlotToContainer(new BaubleSlot(this, player, cInventory, 0, 65, 8, EnumBaubleType.AMULET){
            @Nullable
            @SideOnly(Side.CLIENT)
            public String getSlotTexture()
            {
                return "elterionrpg:items/slot_amulet";
            }
        });
        this.addSlotToContainer(new BaubleSlot(this, player, cInventory, 1, 65, 26, EnumBaubleType.RING){
            @Nullable
            @SideOnly(Side.CLIENT)
            public String getSlotTexture()
            {
                return "elterionrpg:items/slot_ring1";
            }
        });
        this.addSlotToContainer(new BaubleSlot(this, player, cInventory, 2, 65, 44, EnumBaubleType.RING){
            @Nullable
            @SideOnly(Side.CLIENT)
            public String getSlotTexture()
            {
                return "elterionrpg:items/slot_ring2";
            }
        });
        this.addSlotToContainer(new BaubleSlot(this, player, cInventory, 3, 65, 62, EnumBaubleType.BACKPACK){
            @Nullable
            @SideOnly(Side.CLIENT)
            public String getSlotTexture()
            {
                return "elterionrpg:items/slot_backpack";
            }
        });
        this.addSlotToContainer(new BaubleSlot(this, player, cInventory, 4, 46, 80, EnumBaubleType.GLOVE){
            @Nullable
            @SideOnly(Side.CLIENT)
            public String getSlotTexture()
            {
                return "elterionrpg:items/slot_glove";
            }
        });
        this.addSlotToContainer(new BaubleSlot(this, player, cInventory, 5, 27, 80, EnumBaubleType.SHOULDER){
            @Nullable
            @SideOnly(Side.CLIENT)
            public String getSlotTexture()
            {
                return "elterionrpg:items/slot_shoulder";
            }
        });


        for (int k = 0; k < 4; ++k){

            final EntityEquipmentSlot entityequipmentslot = VALID_EQUIPMENT_SLOTS[k];
            this.addSlotToContainer(new Slot(playerInventory, 36 + (3 - k), 8, 8 + k * 18){
                public int getSlotStackLimit(){

                    return 1;
                }

                public boolean isItemValid(ItemStack stack){

                    return stack.getItem().isValidArmor(stack, entityequipmentslot, thePlayer);
                }

                public boolean canTakeStack(EntityPlayer playerIn){

                    ItemStack itemstack = this.getStack();
                    return !itemstack.isEmpty() && !playerIn.isCreative() && EnchantmentHelper.hasBindingCurse(itemstack) ? false : super.canTakeStack(playerIn);
                }
                @Nullable
                @SideOnly(Side.CLIENT)
                public String getSlotTexture(){

                    return ItemArmor.EMPTY_SLOT_NAMES[entityequipmentslot.getIndex()];
                }
            });

        }

        

        for (int l = 0; l < 3; ++l) {

            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlotToContainer(new Slot(playerInventory, j1 + (l + 1) * 9, 8 + j1 * 18 -1, 100 + l * 18));
            }
        }

        for (int i1 = 0; i1 < 9; ++i1) {

            this.addSlotToContainer(new Slot(playerInventory, i1, 8 + i1 * 18 - 1, 158));
        }
        this.addSlotToContainer(new Slot(playerInventory, 47, 65, 80)
        {
            @Nullable
            @SideOnly(Side.CLIENT)
            public String getSlotTexture()
            {
                return "minecraft:items/empty_armor_slot_shield";
            }
        });
        this.thePlayer = player;
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 0, 153, 39));

        for (int i = 0; i < 2; ++i)
        {
            for (int j = 0; j < 2; ++j)
            {
                this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 2, 97 + j * 18, 18 + i * 18+11));
            }
        }
    }
    
    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        this.slotChangedCraftingGrid(this.thePlayer.world, this.thePlayer, this.craftMatrix, this.craftResult);
    }

    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        this.craftResult.clear();

        if (!playerIn.world.isRemote)
        {
            this.clearContainer(playerIn, playerIn.world, this.craftMatrix);
        }
    }


    
    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {


    	        ItemStack itemstack = ItemStack.EMPTY;
    	        Slot slot = (Slot)this.inventorySlots.get(index);


    	        //���� ���� ���������� � �� �� ����
    	        if (slot != null && slot.getHasStack()){

    	            //������� ���� �� �����
    	            ItemStack itemstack1 = slot.getStack();

    	            itemstack = itemstack1.copy();

    	            //��������������
    	            //���� ������ ����� ������ 12, �.�. ����� ������� �� ��������� ���� ��� ���� �����
    	            if (index < 10){

    	                //�������� ����������� ���� � ������ ��������� ���� � ������� ��� ���������, �.�. ����� 12 � 47 ������
    	                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {

    	                    return ItemStack.EMPTY;
    	                }

    	                slot.onSlotChange(itemstack1, itemstack);
    	            }

    	            //����� ��������. ���� ����� ������� �� ���� � ��������� ��� �������
    	            else if (index > 9){

    	                //���� ��� �����, �� �� ���� ����������� � ������ ���������� ��� ��� ���� ����� 8 � 11 ��������
    	                if(itemstack1.getItem() instanceof ItemArmor){

    	                    //��� ���� ������. ������ �������� 12 � �� 11? ������ ��� �� ������������. �.�. ����� 8 � 12 ������ �� ������������
    	                    if (!this.mergeItemStack(itemstack1, 6, 10, false)){
    	                        return ItemStack.EMPTY;
    	                    }

    	                }else 
    	                    //���� ��� �� ����� � �� � ��������� �� �� � �������(�.�. ����� 12 � 38 ������), �� �������� ������� � ������, �.�. ����� 39 � 47 ������
    	                    if (index >= 10 && index < 37){

    	                        if (!this.mergeItemStack(itemstack1, 37, 46, false)){
    	                            return ItemStack.EMPTY;
    	                        }
    	                }else 
    	                    //���� �� � �������(�.�. ����� 39 � 47 ������) �� �������� ����������� ������� � ���������(�.�. ����� � ������ ��������� ������ � ���������, �.�. ����� 12 � 38 ������)
    	                    if (index >= 37 && index < 46 && !this.mergeItemStack(itemstack1, 10, 37, false)){
    	                        return ItemStack.EMPTY;
    	                    }
    	            }        


    	            //��������� ������� ��������
    	            if (itemstack1.getCount() == 0){
    	                slot.putStack(ItemStack.EMPTY);
    	            }
    	            else{
    	                slot.onSlotChanged();
    	            }

    	            if (itemstack1.getCount() == itemstack.getCount()){
    	                return ItemStack.EMPTY;
    	            }

    	            slot.onTake(playerIn, itemstack1);
    	        }

    	        return itemstack;
    	    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {

        return true;
    }
 /*   public boolean canMergeSlot(ItemStack stack, Slot slotIn)
    {
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }
   */ 
}
