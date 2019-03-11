package ru.lnti.decorelterion.Blocks;

import ru.lnti.decorelterion.decorelterion;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class Block_collision extends Block
{
	
	
    public static final PropertyEnum<Block_collision.EnumType> VARIANT = PropertyEnum.<Block_collision.EnumType>create("variant", Block_collision.EnumType.class);

    public Block_collision(String name, float hardness, float resistanse , SoundType soundtype)
    {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().cycleProperty(VARIANT));
        this.setCreativeTab(decorelterion.TabsELTB);
        this.setRegistryName(name);
    }

    public int damageDropped(IBlockState state)
    {
        return ((Block_collision.EnumType)state.getValue(VARIANT)).getMetadata();
    }
//метод позволяющий нам указать, откуда брать субтипы.
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (Block_collision.EnumType block_collision$enumtype : Block_collision.EnumType.values())
        {
            items.add(new ItemStack(this, 1, block_collision$enumtype.getMetadata()));
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, Block_collision.EnumType.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Block_collision.EnumType)state.getValue(VARIANT)).getMetadata();
    }
//обязательно создаем контейнер стейтов
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
//перечисление наших подтипов
    public static enum EnumType implements IStringSerializable
    {
        CAMPFIRE(0, "campfire", true),
        RB_BARREL(1, "rb_barrel", true),
        CART_HAND(2, "cart_hand", true),
        CHAIR_FANCY(3,"chair_fancy",true),
		CHEST(4,"chest",true),
        VASE_SMALL(5,"vase_small",true),
        VASE_LARGE(6,"vase_large",true),
        TOOLHANGER_SMITH(7,"toolhanger_smith",true),
        SIGNPOST(8,"signpost",true),
        WOODENTABLE_POOR(9,"woodentable_poor",true);

		


        private static final Block_collision.EnumType[] META_LOOKUP = new Block_collision.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        private final boolean isNatural;

        private EnumType(int meta, String name, boolean isNatural)
        {
            this(meta,  name, name, isNatural);
        }

        private EnumType(int meta,  String name, String Uname, boolean isNatural)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = Uname;
            this.isNatural = isNatural;
        }

        public int getMetadata()
        {
            return this.meta;
        }


        public String toString()
        {
            return this.name;
        }

        public static Block_collision.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        public boolean isNatural()
        {
            return this.isNatural;
        }

        static
        {
            for (Block_collision.EnumType block_collision$enumtype : values())
            {
                META_LOOKUP[block_collision$enumtype.getMetadata()] = block_collision$enumtype;
            }
        }
    }
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    @Override 
    public BlockRenderLayer getBlockLayer() { 
    return BlockRenderLayer.TRANSLUCENT; 
    }

}
