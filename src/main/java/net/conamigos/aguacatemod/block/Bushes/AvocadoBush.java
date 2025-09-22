package net.conamigos.aguacatemod.block.Bushes;

import net.conamigos.aguacatemod.item.Ingredients.AvocadoItem.AvocadoItem;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;


public class AvocadoBush extends SweetBerryBushBlock {

    public AvocadoBush(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {

        return new ItemStack(AvocadoItem.AVOCADO);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        int age = (Integer)state.get(AGE);
        boolean mature = age == 3;
        if (age > 1) {
            int base = 1 + world.random.nextInt(2);
            int total = base + (mature ? 1 : 0);
            dropStack(world, pos, new ItemStack(AvocadoItem.AVOCADO, total));
            world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            BlockState blockState = (BlockState)state.with(AGE, 1);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.success(world.isClient);
        }
            return super.onUse(state, world, pos, player, hit);
    }
}
