package ru.lnti.decorelterion.register;

import ru.lnti.decorelterion.Blocks.Block_collision;
import ru.lnti.decorelterion.Blocks.Block_light;
import ru.lnti.decorelterion.Blocks.Block_nocollision;
import ru.lnti.decorelterion.Blocks.Block_polcollision;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegMetaBlocks {
	 @SubscribeEvent
	    public void registerMetaBlocks(ModelRegistryEvent e) {
	            register(BlocksRegister.Block_collision);
	            register(BlocksRegister.Block_polcollision);
	            register(BlocksRegister.Block_nocollision);
	            register(BlocksRegister.Block_light);
	    }


	    public void register(Block block)
	    {
	        for(Block_collision.EnumType type : Block_collision.EnumType.values())
	        {
	            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), type.getMetadata(), new ModelResourceLocation(block.getRegistryName() + "_" + type.getName(), "inventory"));
	        }
	        for(Block_polcollision.EnumType type : Block_polcollision.EnumType.values())
	        {
	            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), type.getMetadata(), new ModelResourceLocation(block.getRegistryName() + "_" + type.getName(), "inventory"));
	        }
	        for(Block_light.EnumType type : Block_light.EnumType.values())
	        {
	            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), type.getMetadata(), new ModelResourceLocation(block.getRegistryName() + "_" + type.getName(), "inventory"));
	        }
	        for(Block_nocollision.EnumType type : Block_nocollision.EnumType.values())
	        {
	            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), type.getMetadata(), new ModelResourceLocation(block.getRegistryName() + "_" + type.getName(), "inventory"));
	        }
	    }
	}

