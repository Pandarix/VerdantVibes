package net.Pandarix.verdantvibes.init;

import com.mojang.serialization.Codec;
import net.Pandarix.verdantvibes.VerdantVibes;
import net.Pandarix.verdantvibes.woldgen.tree.decorator.TrunkIvyDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TreeDecoratorInit<P extends TreeDecorator> {
    public static final DeferredRegister<TreeDecoratorType<?>> DECORATORS = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, VerdantVibes.MOD_ID);
    public static final RegistryObject<TreeDecoratorType<TrunkIvyDecorator>> TRUNK_IVY = register("trunk_ivy", TrunkIvyDecorator.CODEC);
    private final Codec<P> codec;

    private static <P extends TreeDecorator> RegistryObject<TreeDecoratorType<P>> register(String name, Codec<P> pCodec) {
        return DECORATORS.register(name, ()-> new TreeDecoratorType<>(pCodec));
    }

    public TreeDecoratorInit(Codec<P> pCodec) {
        this.codec = pCodec;
    }

    public Codec<P> codec() {
        return this.codec;
    }
}
