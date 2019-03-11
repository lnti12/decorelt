package ru.lnti.decorelterion.register;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.lnti.decorelterion.Blocks.Block_collision;
import ru.lnti.decorelterion.Blocks.Block_polcollision;
import ru.lnti.decorelterion.Blocks.Block_nocollision;
import ru.lnti.decorelterion.Items.ItemBlock_collision;
import ru.lnti.decorelterion.Items.ItemBlock_light;
import ru.lnti.decorelterion.Items.ItemBlock_nocollision;
import ru.lnti.decorelterion.Items.ItemBlock_polcollision;
import ru.lnti.decorelterion.Blocks.Block_light;

public class BlocksRegister 
{

	public static Block Block_collision = new Block_collision("block_collision", 1,  1, SoundType.WOOD);
	public static Block Block_polcollision = new Block_polcollision("block_polcollision", 1,  1, SoundType.WOOD);
	public static Block Block_light = new Block_light("block_light", 1,  1, SoundType.WOOD);
	public static Block Block_nocollision = new Block_nocollision("block_nocollision", 1,  1, SoundType.WOOD);



    public static void register()
    {

    	 registerBlockMeta(Block_collision, new ItemBlock_collision(Block_collision));
    	 registerBlockMeta(Block_polcollision, new ItemBlock_polcollision(Block_polcollision));
    	 registerBlockMeta(Block_light, new ItemBlock_light(Block_light));
    	 registerBlockMeta(Block_nocollision, new ItemBlock_nocollision(Block_nocollision));

    }
    @SideOnly(Side.CLIENT)
    public static void registerRender()
    {


    }


    public static void registerBlockMeta(Block block, ItemBlock itemBlock) {
    ForgeRegistries.BLOCKS.register(block);
    ForgeRegistries.ITEMS.register(itemBlock.setRegistryName(block.getRegistryName()));
    }
    
    @SideOnly(Side.CLIENT)
    private static void setRender(Block block)
    {
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));

    }
}


