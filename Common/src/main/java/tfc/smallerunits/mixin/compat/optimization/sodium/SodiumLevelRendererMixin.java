package tfc.smallerunits.mixin.compat.optimization.sodium;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import me.jellysquid.mods.sodium.client.render.SodiumWorldRenderer;
import me.jellysquid.mods.sodium.client.render.chunk.RenderSectionManager;
import me.jellysquid.mods.sodium.client.render.viewport.frustum.Frustum;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.server.level.BlockDestructionProgress;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfc.smallerunits.client.abstraction.SodiumFrustum;
import tfc.smallerunits.client.render.compat.sodium.SodiumRenderer;

import java.util.SortedSet;

@Mixin(value = SodiumWorldRenderer.class, remap = false)
public abstract class SodiumLevelRendererMixin {
	@Shadow
	private RenderSectionManager renderSectionManager;
	
	@Shadow
	private ClientLevel world;
	
	@Shadow
	@Final
	private Minecraft client;
	
	@Unique
	SodiumFrustum frustum = new SodiumFrustum();
	
	@Inject(at = @At("TAIL"), method = "drawChunkLayer")
	public void preRenderSomething(RenderType renderLayer, PoseStack matrixStack, double x, double y, double z, CallbackInfo ci) {
		SodiumRenderer.render(
				renderLayer, matrixStack, x, y, z, ci,
				frustum, client, world, renderSectionManager
		);
	}
}
