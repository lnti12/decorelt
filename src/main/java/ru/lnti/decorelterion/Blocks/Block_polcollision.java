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
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lnti.decorelterion.decorelterion;

public class Block_polcollision extends Block
{
	public static final AxisAlignedBB COLLISION_AABB = new AxisAlignedBB(0, 0, 0, 1, 0.5, 1);
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	    {
	        return COLLISION_AABB;
	    }
    public static final PropertyEnum<Block_polcollision.EnumType> VARIANT = PropertyEnum.<Block_polcollision.EnumType>create("variant", Block_polcollision.EnumType.class);

    public Block_polcollision(String name, float hardness, float resistanse , SoundType soundtype)
    {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().cycleProperty(VARIANT));
        this.setCreativeTab(decorelterion.TabsELTB);
        this.setRegistryName(name);
        
    }

    public int damageDropped(IBlockState state)
    {
        return ((Block_polcollision.EnumType)state.getValue(VARIANT)).getMetadata();
    }
//метод позволяющий нам указать, откуда брать субтипы.
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (Block_polcollision.EnumType block_polcollision$enumtype : Block_polcollision.EnumType.values())
        {
            items.add(new ItemStack(this, 1, block_polcollision$enumtype.getMetadata()));
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, Block_polcollision.EnumType.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Block_polcollision.EnumType)state.getValue(VARIANT)).getMetadata();
    }
//обязательно создаем контейнер стейтов
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
//перечисление наших подтипов
    public static enum EnumType implements IStringSerializable
    {
       
    	WOODEN_STOOL(0,"wooden_stool",true),
    	ROCKS_SCHIST(1,"rocks_schist",true),
		EMPTY_CRATE(2,"empty_crate",true);

        private static final Block_polcollision.EnumType[] META_LOOKUP = new Block_polcollision.EnumType[values().length];
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

        public static Block_polcollision.EnumType byMetadata(int meta)
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
            for (Block_polcollision.EnumType block_polcollision$enumtype : values())
            {
                META_LOOKUP[block_polcollision$enumtype.getMetadata()] = block_polcollision$enumtype;
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

}
