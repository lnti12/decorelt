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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.lnti.decorelterion.decorelterion;

public class Block_nocollision extends Block
{
    public static final PropertyEnum<Block_nocollision.EnumType> VARIANT = PropertyEnum.<Block_nocollision.EnumType>create("variant", Block_nocollision.EnumType.class);

    public static final AxisAlignedBB COLLISION_AABB = new AxisAlignedBB(0, 0, 0, 1, 0, 1);
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	    {
	        return COLLISION_AABB;
	    }
    
    public Block_nocollision(String name, float hardness, float resistanse , SoundType soundtype)
    {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().cycleProperty(VARIANT));
        this.setCreativeTab(decorelterion.TabsELTB);
        this.setRegistryName(name);
    }

    public int damageDropped(IBlockState state)
    {
        return ((Block_nocollision.EnumType)state.getValue(VARIANT)).getMetadata();
    }
//метод позволяющий нам указать, откуда брать субтипы.
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (Block_nocollision.EnumType block_nocollision$enumtype : Block_nocollision.EnumType.values())
        {
            items.add(new ItemStack(this, 1, block_nocollision$enumtype.getMetadata()));
        }
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, Block_nocollision.EnumType.byMetadata(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Block_nocollision.EnumType)state.getValue(VARIANT)).getMetadata();
    }
//обязательно создаем контейнер стейтов
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
//перечисление наших подтипов
    public static enum EnumType implements IStringSerializable
    {
		WOODEN_BUCKET(0,"wooden_bucket",true),
		PITCHFORK(1,"pitchfork",true),
		SCALE(2,"scale",true),
		WOODEN_TANKARD(3,"wooden_tankard",true),
		CHEESE_CUT(4,"cheese_cut",true),
        HAND_UNLITCANDLE(5, "hand_unlitcandle", true),
        EXTREMEHILS(6, "extremehills", true);
       


        private static final Block_nocollision.EnumType[] META_LOOKUP = new Block_nocollision.EnumType[values().length];
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

        public static Block_nocollision.EnumType byMetadata(int meta)
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
            for (Block_nocollision.EnumType block_nocollision$enumtype : values())
            {
                META_LOOKUP[block_nocollision$enumtype.getMetadata()] = block_nocollision$enumtype;
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