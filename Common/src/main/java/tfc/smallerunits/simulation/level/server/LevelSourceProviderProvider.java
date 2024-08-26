package tfc.smallerunits.simulation.level.server;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class LevelSourceProviderProvider {
	public static ChunkGenerator createGenerator(String version, Level lvl, BlockPos pos) {
		return generator181(lvl, pos);
	}

	public static ChunkGenerator generator181(Level lvl, BlockPos pos) {
		return new FlatLevelSource(
				new FlatLevelGeneratorSettings(
						Optional.empty(),
                        lvl.getBiome(pos),
                        List.of(Holder.direct(Objects.requireNonNull(lvl.registryAccess().registry(Registries.PLACED_FEATURE).get().get(Registries.PLACED_FEATURE.registry()))))
				)
		);
	}
}
