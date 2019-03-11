package ru.lnti.decorelterion.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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
import ru.lnti.decorelterion.decorelterion;

public class Block_light extends Block
{
    public static final PropertyEnum<Block_light.EnumType> VARIANT = PropertyEnum.<Block_light.EnumType>create("variant", Block_light.EnumType.class);

    public Block_light(String name, float hardness, float resistanse , SoundType soundtype)
    {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().cycleProperty(VARIANT));
        this.setCreativeTab(decorelterion.TabsELTB);
        this.setLightLevel(1);
        this.setRegistryName(name);
    }

    public int damageDropped(IBlockState state)
    {
        return ((Block_light.EnumType)state.getValue(VARIANT)).getMetadata();
    }
//метод позволяющий нам указать, откуда брать субтипы.
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (Block_light.EnumType block_light$enumtype : Block_light.EnumType.values())
        {
            items.add(new ItemStack(this, 1, block_light$enumtype.getMetadata()));
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, Block_light.EnumType.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Block_light.EnumType)state.getValue(VARIANT)).getMetadata();
    }
//обязательно создаем контейнер стейтов
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
//перечисление наших подтипов
    public static enum EnumType implements IStringSerializable
    {
        CAMPFIRE_FIRE(0, "campfire_fire", true),
        BEACON(1, "beacon", true);
       


        private static final Block_light.EnumType[] META_LOOKUP = new Block_light.EnumType[values().length];
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

        public static Block_light.EnumType byMetadata(int meta)
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
            for (Block_light.EnumType block_light$enumtype : values())
            {
                META_LOOKUP[block_light$enumtype.getMetadata()] = block_light$enumtype;
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