package com.tfc.smallerunits;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tfc.smallerunits.registry.Deferred;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Random;

public class Group extends ItemGroup {
	public static final String[] strings = new String[]{
			"0,0,0,Block{minecraft:stone},\"{}\";1,0,0,Block{minecraft:stone},\"{}\";2,0,0,Block{minecraft:stone},\"{}\";4,4,2,Block{minecraft:grass_block}[snowy=false],\"{}\";0,4,6,Block{minecraft:grass_block}[snowy=false],\"{}\";3,0,0,Block{minecraft:stone},\"{}\";5,4,2,Block{minecraft:grass_block}[snowy=false],\"{}\";1,4,6,Block{minecraft:grass_block}[snowy=false],\"{}\";4,0,0,Block{minecraft:stone},\"{}\";6,4,2,Block{minecraft:grass_block}[snowy=false],\"{}\";2,4,6,Block{minecraft:grass_block}[snowy=false],\"{}\";5,0,0,Block{minecraft:stone},\"{}\";7,4,2,Block{minecraft:grass_block}[snowy=false],\"{}\";6,0,0,Block{minecraft:stone},\"{}\";7,2,1,Block{minecraft:stone},\"{}\";7,0,0,Block{minecraft:stone},\"{}\";6,4,6,Block{minecraft:grass_block}[snowy=false],\"{}\";7,4,6,Block{minecraft:grass_block}[snowy=false],\"{}\";7,2,5,Block{minecraft:dirt},\"{}\";7,0,4,Block{minecraft:coal_ore},\"{}\";0,3,1,Block{minecraft:grass_block}[snowy=false],\"{}\";0,1,0,Block{minecraft:stone},\"{}\";1,3,1,Block{minecraft:grass_block}[snowy=false],\"{}\";1,1,0,Block{minecraft:stone},\"{}\";2,1,0,Block{minecraft:stone},\"{}\";3,1,0,Block{minecraft:stone},\"{}\";0,3,5,Block{minecraft:grass_block}[snowy=false],\"{}\";4,1,0,Block{minecraft:iron_ore},\"{}\";1,3,5,Block{minecraft:grass_block}[snowy=false],\"{}\";5,1,0,Block{minecraft:iron_ore},\"{}\";3,5,6,Block{minecraft:grass_block}[snowy=false],\"{}\";6,1,0,Block{minecraft:stone},\"{}\";7,3,1,Block{minecraft:dirt},\"{}\";4,5,6,Block{minecraft:grass_block}[snowy=false],\"{}\";7,1,0,Block{minecraft:stone},\"{}\";5,5,6,Block{minecraft:grass_block}[snowy=false],\"{}\";7,3,5,Block{minecraft:grass_block}[snowy=false],\"{}\";7,1,4,Block{minecraft:coal_ore},\"{}\";0,2,0,Block{minecraft:dirt},\"{}\";1,2,0,Block{minecraft:dirt},\"{}\";2,4,1,Block{minecraft:grass_block}[snowy=false],\"{}\";2,2,0,Block{minecraft:stone},\"{}\";3,4,1,Block{minecraft:grass_block}[snowy=false],\"{}\";3,2,0,Block{minecraft:stone},\"{}\";4,4,1,Block{minecraft:grass_block}[snowy=false],\"{}\";4,2,0,Block{minecraft:iron_ore},\"{}\";5,2,0,Block{minecraft:stone},\"{}\";1,2,4,Block{minecraft:grass_block}[snowy=false],\"{}\";2,4,5,Block{minecraft:grass_block}[snowy=false],\"{}\";6,2,0,Block{minecraft:stone},\"{}\";7,4,1,Block{minecraft:grass_block}[snowy=false],\"{}\";3,4,5,Block{minecraft:grass_block}[snowy=false],\"{}\";7,2,0,Block{minecraft:stone},\"{}\";4,4,5,Block{minecraft:grass_block}[snowy=false],\"{}\";5,4,5,Block{minecraft:grass_block}[snowy=false],\"{}\";6,4,5,Block{minecraft:grass_block}[snowy=false],\"{}\";7,2,4,Block{minecraft:dirt},\"{}\";7,0,3,Block{minecraft:coal_ore},\"{}\";7,0,7,Block{minecraft:stone},\"{}\";0,3,0,Block{minecraft:grass_block}[snowy=false],\"{}\";1,3,0,Block{minecraft:dirt},\"{}\";2,3,0,Block{minecraft:dirt},\"{}\";3,3,0,Block{minecraft:stone},\"{}\";4,3,0,Block{minecraft:stone},\"{}\";5,5,1,Block{minecraft:grass_block}[snowy=false],\"{}\";0,3,4,Block{minecraft:grass_block}[snowy=false],\"{}\";5,3,0,Block{minecraft:dirt},\"{}\";6,5,1,Block{minecraft:grass_block}[snowy=false],\"{}\";6,3,0,Block{minecraft:dirt},\"{}\";2,3,4,Block{minecraft:grass_block}[snowy=false],\"{}\";7,3,0,Block{minecraft:dirt},\"{}\";3,3,4,Block{minecraft:grass_block}[snowy=false],\"{}\";7,3,4,Block{minecraft:grass_block}[snowy=false],\"{}\";7,1,3,Block{minecraft:coal_ore},\"{}\";7,1,7,Block{minecraft:stone},\"{}\";1,4,0,Block{minecraft:grass_block}[snowy=false],\"{}\";2,4,0,Block{minecraft:grass_block}[snowy=false],\"{}\";3,4,0,Block{minecraft:dirt},\"{}\";4,4,0,Block{minecraft:dirt},\"{}\";5,4,0,Block{minecraft:dirt},\"{}\";0,2,3,Block{minecraft:grass_block}[snowy=false],\"{}\";6,4,0,Block{minecraft:dirt},\"{}\";1,2,3,Block{minecraft:grass_block}[snowy=false],\"{}\";7,4,0,Block{minecraft:grass_block}[snowy=false],\"{}\";4,4,4,Block{minecraft:grass_block}[snowy=false],\"{}\";5,4,4,Block{minecraft:grass_block}[snowy=false],\"{}\";6,4,4,Block{minecraft:grass_block}[snowy=false],\"{}\";7,2,3,Block{minecraft:dirt},\"{}\";7,0,2,Block{minecraft:coal_ore},\"{}\";7,2,7,Block{minecraft:stone},\"{}\";7,0,6,Block{minecraft:coal_ore},\"{}\";3,5,0,Block{minecraft:grass_block}[snowy=false],\"{}\";4,5,0,Block{minecraft:grass_block}[snowy=false],\"{}\";5,5,0,Block{minecraft:grass_block}[snowy=false],\"{}\";6,5,0,Block{minecraft:grass_block}[snowy=false],\"{}\";2,3,3,Block{minecraft:grass_block}[snowy=false],\"{}\";3,3,3,Block{minecraft:grass_block}[snowy=false],\"{}\";4,3,3,Block{minecraft:grass_block}[snowy=false],\"{}\";7,3,3,Block{minecraft:dirt},\"{}\";7,1,2,Block{minecraft:stone},\"{}\";7,3,7,Block{minecraft:dirt},\"{}\";7,1,6,Block{minecraft:stone},\"{}\";0,2,2,Block{minecraft:grass_block}[snowy=false],\"{}\";5,4,3,Block{minecraft:grass_block}[snowy=false],\"{}\";6,4,3,Block{minecraft:grass_block}[snowy=false],\"{}\";7,4,3,Block{minecraft:grass_block}[snowy=false],\"{}\";7,2,2,Block{minecraft:dirt},\"{}\";7,0,1,Block{minecraft:stone},\"{}\";6,4,7,Block{minecraft:grass_block}[snowy=false],\"{}\";7,4,7,Block{minecraft:grass_block}[snowy=false],\"{}\";7,2,6,Block{minecraft:stone},\"{}\";7,0,5,Block{minecraft:coal_ore},\"{}\";1,3,2,Block{minecraft:grass_block}[snowy=false],\"{}\";2,3,2,Block{minecraft:grass_block}[snowy=false],\"{}\";3,3,2,Block{minecraft:grass_block}[snowy=false],\"{}\";0,5,7,Block{minecraft:grass_block}[snowy=false],\"{}\";1,5,7,Block{minecraft:grass_block}[snowy=false],\"{}\";2,5,7,Block{minecraft:grass_block}[snowy=false],\"{}\";3,5,7,Block{minecraft:grass_block}[snowy=false],\"{}\";7,3,2,Block{minecraft:dirt},\"{}\";4,5,7,Block{minecraft:grass_block}[snowy=false],\"{}\";7,1,1,Block{minecraft:stone},\"{}\";5,5,7,Block{minecraft:grass_block}[snowy=false],\"{}\";7,3,6,Block{minecraft:dirt},\"{}\";7,1,5,Block{minecraft:coal_ore},\"{}\";"
			,
			"0,0,0,Block{minecraft:cobblestone},\"{}\";1,2,1,Block{minecraft:oak_log}[axis=y],\"{}\";3,6,3,Block{minecraft:oak_planks},\"{}\";1,0,0,Block{minecraft:cobblestone},\"{}\";4,6,3,Block{minecraft:oak_planks},\"{}\";2,0,0,Block{minecraft:cobblestone},\"{}\";5,6,3,Block{minecraft:oak_stairs}[facing=west|half=bottom|shape=straight|waterlogged=true],\"{}\";3,0,0,Block{minecraft:cobblestone},\"{}\";4,0,0,Block{minecraft:cobblestone},\"{}\";6,4,2,Block{minecraft:oak_log}[axis=z],\"{}\";5,0,0,Block{minecraft:cobblestone},\"{}\";6,2,1,Block{minecraft:oak_log}[axis=y],\"{}\";6,0,0,Block{minecraft:cobblestone},\"{}\";7,0,0,Block{minecraft:cobblestone},\"{}\";6,4,6,Block{minecraft:oak_log}[axis=y],\"{}\";5,2,5,Block{minecraft:oak_planks},\"{}\";7,0,4,Block{minecraft:cobblestone},\"{}\";1,3,1,Block{minecraft:oak_log}[axis=y],\"{}\";2,5,2,Block{minecraft:oak_planks},\"{}\";5,5,2,Block{minecraft:oak_planks},\"{}\";6,5,2,Block{minecraft:oak_stairs}[facing=south|half=bottom|shape=outer_right|waterlogged=true],\"{}\";6,3,1,Block{minecraft:oak_log}[axis=y],\"{}\";6,5,6,Block{minecraft:oak_log}[axis=y],\"{}\";5,3,5,Block{minecraft:oak_planks},\"{}\";6,1,4,Block{minecraft:cobblestone_stairs}[facing=west|half=bottom|shape=straight|waterlogged=true],\"{}\";1,4,1,Block{minecraft:oak_log}[axis=y],\"{}\";2,6,2,Block{minecraft:oak_stairs}[facing=east|half=bottom|shape=outer_right|waterlogged=true],\"{}\";2,4,1,Block{minecraft:oak_log}[axis=x],\"{}\";3,6,2,Block{minecraft:oak_stairs}[facing=south|half=bottom|shape=straight|waterlogged=true],\"{}\";3,4,1,Block{minecraft:oak_log}[axis=x],\"{}\";4,6,2,Block{minecraft:oak_stairs}[facing=south|half=bottom|shape=straight|waterlogged=true],\"{}\";4,4,1,Block{minecraft:oak_log}[axis=x],\"{}\";5,6,2,Block{minecraft:oak_stairs}[facing=west|half=bottom|shape=outer_left|waterlogged=true],\"{}\";5,4,1,Block{minecraft:oak_log}[axis=x],\"{}\";6,4,1,Block{minecraft:oak_log}[axis=y],\"{}\";6,4,5,Block{minecraft:oak_log}[axis=z],\"{}\";5,2,4,Block{minecraft:oak_planks},\"{}\";7,0,3,Block{minecraft:cobblestone},\"{}\";6,0,7,Block{minecraft:cobblestone},\"{}\";7,0,7,Block{minecraft:cobblestone},\"{}\";1,5,1,Block{minecraft:oak_log}[axis=y],\"{}\";2,5,1,Block{minecraft:oak_stairs}[facing=east|half=bottom|shape=outer_right|waterlogged=true],\"{}\";3,5,1,Block{minecraft:oak_stairs}[facing=south|half=bottom|shape=straight|waterlogged=true],\"{}\";4,5,1,Block{minecraft:oak_stairs}[facing=south|half=bottom|shape=straight|waterlogged=true],\"{}\";5,5,1,Block{minecraft:oak_stairs}[facing=west|half=bottom|shape=outer_left|waterlogged=true],\"{}\";6,5,1,Block{minecraft:oak_log}[axis=y],\"{}\";3,1,3,Block{minecraft:polished_andesite},\"{}\";5,5,5,Block{minecraft:oak_planks},\"{}\";6,5,5,Block{minecraft:oak_stairs}[facing=north|half=bottom|shape=outer_left|waterlogged=true],\"{}\";5,3,4,Block{minecraft:oak_planks},\"{}\";4,1,3,Block{minecraft:polished_andesite},\"{}\";6,1,3,Block{minecraft:cobblestone_stairs}[facing=west|half=bottom|shape=straight|waterlogged=true],\"{}\";2,6,5,Block{minecraft:oak_stairs}[facing=east|half=bottom|shape=outer_left|waterlogged=true],\"{}\";3,6,5,Block{minecraft:oak_stairs}[facing=north|half=bottom|shape=straight|waterlogged=true],\"{}\";2,2,3,Block{minecraft:oak_planks},\"{}\";4,6,5,Block{minecraft:oak_stairs}[facing=north|half=bottom|shape=straight|waterlogged=true],\"{}\";5,6,5,Block{minecraft:oak_stairs}[facing=north|half=bottom|shape=outer_left|waterlogged=true],\"{}\";6,4,4,Block{minecraft:oak_log}[axis=z],\"{}\";5,2,3,Block{minecraft:oak_planks},\"{}\";7,0,2,Block{minecraft:cobblestone},\"{}\";7,0,6,Block{minecraft:cobblestone},\"{}\";2,3,3,Block{minecraft:oak_planks},\"{}\";3,1,2,Block{minecraft:polished_andesite},\"{}\";6,5,4,Block{minecraft:oak_stairs}[facing=west|half=bottom|shape=straight|waterlogged=true],\"{}\";5,3,3,Block{minecraft:oak_planks},\"{}\";4,1,2,Block{minecraft:polished_andesite},\"{}\";6,1,2,Block{minecraft:cobblestone_stairs}[facing=west|half=bottom|shape=straight|waterlogged=true],\"{}\";6,1,6,Block{minecraft:oak_log}[axis=y],\"{}\";2,6,4,Block{minecraft:oak_stairs}[facing=east|half=bottom|shape=straight|waterlogged=true],\"{}\";0,0,1,Block{minecraft:cobblestone},\"{}\";3,6,4,Block{minecraft:oak_planks},\"{}\";2,2,2,Block{minecraft:oak_planks},\"{}\";4,6,4,Block{minecraft:oak_planks},\"{}\";5,6,4,Block{minecraft:oak_stairs}[facing=west|half=bottom|shape=straight|waterlogged=true],\"{}\";6,4,3,Block{minecraft:oak_log}[axis=z],\"{}\";5,2,2,Block{minecraft:oak_planks},\"{}\";7,0,1,Block{minecraft:cobblestone},\"{}\";6,2,6,Block{minecraft:oak_log}[axis=y],\"{}\";7,0,5,Block{minecraft:cobblestone},\"{}\";1,1,1,Block{minecraft:oak_log}[axis=y],\"{}\";2,3,2,Block{minecraft:oak_planks},\"{}\";2,1,1,Block{minecraft:cobblestone_stairs}[facing=south|half=bottom|shape=straight|waterlogged=true],\"{}\";3,1,1,Block{minecraft:cobblestone_stairs}[facing=south|half=bottom|shape=straight|waterlogged=true],\"{}\";4,1,1,Block{minecraft:cobblestone_stairs}[facing=south|half=bottom|shape=straight|waterlogged=true],\"{}\";6,5,3,Block{minecraft:oak_stairs}[facing=west|half=bottom|shape=straight|waterlogged=true],\"{}\";5,3,2,Block{minecraft:oak_planks},\"{}\";5,1,1,Block{minecraft:cobblestone_stairs}[facing=south|half=bottom|shape=straight|waterlogged=true],\"{}\";6,1,1,Block{minecraft:oak_log}[axis=y],\"{}\";6,3,6,Block{minecraft:oak_log}[axis=y],\"{}\";6,1,5,Block{minecraft:cobblestone_stairs}[facing=west|half=bottom|shape=straight|waterlogged=true],\"{}\";2,6,3,Block{minecraft:oak_stairs}[facing=east|half=bottom|shape=straight|waterlogged=true],\"{}\";"
			,
			"0,0,0,Block{minecraft:cobblestone},\"{}\";1,2,1,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";1,0,0,Block{minecraft:polished_andesite},\"{}\";2,0,0,Block{minecraft:grass_block}[snowy=false],\"{}\";3,0,0,Block{minecraft:grass_block}[snowy=false],\"{}\";1,4,6,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";0,0,4,Block{minecraft:grass_block}[snowy=false],\"{}\";4,0,0,Block{minecraft:grass_block}[snowy=false],\"{}\";6,4,2,Block{minecraft:oak_log}[axis=z],\"{}\";2,4,6,Block{minecraft:oak_log}[axis=x],\"{}\";5,0,0,Block{minecraft:grass_block}[snowy=false],\"{}\";6,2,1,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";3,4,6,Block{minecraft:oak_log}[axis=x],\"{}\";1,0,4,Block{minecraft:dark_oak_log}[axis=z],\"{}\";6,0,0,Block{minecraft:polished_andesite},\"{}\";4,4,6,Block{minecraft:oak_log}[axis=x],\"{}\";2,0,4,Block{minecraft:stripped_birch_log}[axis=z],\"{}\";7,0,0,Block{minecraft:cobblestone},\"{}\";3,0,4,Block{minecraft:grass_block}[snowy=false],\"{}\";5,4,6,Block{minecraft:oak_log}[axis=x],\"{}\";4,0,4,Block{minecraft:grass_block}[snowy=false],\"{}\";6,4,6,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";5,0,4,Block{minecraft:stripped_birch_log}[axis=z],\"{}\";6,0,4,Block{minecraft:dark_oak_log}[axis=z],\"{}\";7,0,4,Block{minecraft:grass_block}[snowy=false],\"{}\";1,3,1,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";6,3,1,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";1,4,1,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";2,4,1,Block{minecraft:oak_log}[axis=x],\"{}\";3,4,1,Block{minecraft:oak_log}[axis=x],\"{}\";4,4,1,Block{minecraft:oak_log}[axis=x],\"{}\";5,4,1,Block{minecraft:oak_log}[axis=x],\"{}\";1,4,5,Block{minecraft:oak_log}[axis=z],\"{}\";0,0,3,Block{minecraft:grass_block}[snowy=false],\"{}\";6,4,1,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";1,0,3,Block{minecraft:dark_oak_log}[axis=z],\"{}\";2,0,3,Block{minecraft:stripped_birch_log}[axis=z],\"{}\";3,0,3,Block{minecraft:grass_block}[snowy=false],\"{}\";0,0,7,Block{minecraft:cobblestone},\"{}\";4,0,3,Block{minecraft:grass_block}[snowy=false],\"{}\";6,4,5,Block{minecraft:oak_log}[axis=z],\"{}\";1,0,7,Block{minecraft:polished_andesite},\"{}\";5,0,3,Block{minecraft:stripped_birch_log}[axis=z],\"{}\";2,0,7,Block{minecraft:grass_block}[snowy=false],\"{}\";6,0,3,Block{minecraft:dark_oak_log}[axis=z],\"{}\";3,0,7,Block{minecraft:grass_block}[snowy=false],\"{}\";7,0,3,Block{minecraft:grass_block}[snowy=false],\"{}\";4,0,7,Block{minecraft:grass_block}[snowy=false],\"{}\";5,0,7,Block{minecraft:grass_block}[snowy=false],\"{}\";6,0,7,Block{minecraft:polished_andesite},\"{}\";7,0,7,Block{minecraft:cobblestone},\"{}\";1,4,4,Block{minecraft:oak_log}[axis=z],\"{}\";0,0,2,Block{minecraft:grass_block}[snowy=false],\"{}\";1,0,2,Block{minecraft:dark_oak_log}[axis=z],\"{}\";2,0,2,Block{minecraft:grass_block}[snowy=false],\"{}\";3,0,2,Block{minecraft:stripped_birch_log}[axis=x],\"{}\";0,0,6,Block{minecraft:polished_andesite},\"{}\";6,4,4,Block{minecraft:oak_log}[axis=z],\"{}\";4,0,2,Block{minecraft:stripped_birch_log}[axis=x],\"{}\";1,0,6,Block{minecraft:polished_andesite},\"{}\";5,0,2,Block{minecraft:grass_block}[snowy=false],\"{}\";2,0,6,Block{minecraft:dark_oak_log}[axis=x],\"{}\";6,0,2,Block{minecraft:dark_oak_log}[axis=z],\"{}\";7,0,2,Block{minecraft:grass_block}[snowy=false],\"{}\";3,0,6,Block{minecraft:dark_oak_log}[axis=x],\"{}\";4,0,6,Block{minecraft:dark_oak_log}[axis=x],\"{}\";5,0,6,Block{minecraft:dark_oak_log}[axis=x],\"{}\";6,0,6,Block{minecraft:polished_andesite},\"{}\";7,0,6,Block{minecraft:polished_andesite},\"{}\";1,1,6,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";6,1,6,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";1,4,3,Block{minecraft:oak_log}[axis=z],\"{}\";0,0,1,Block{minecraft:polished_andesite},\"{}\";1,0,1,Block{minecraft:polished_andesite},\"{}\";2,0,1,Block{minecraft:dark_oak_log}[axis=x],\"{}\";3,0,1,Block{minecraft:dark_oak_log}[axis=x],\"{}\";0,0,5,Block{minecraft:grass_block}[snowy=false],\"{}\";6,4,3,Block{minecraft:oak_log}[axis=z],\"{}\";1,2,6,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";4,0,1,Block{minecraft:dark_oak_log}[axis=x],\"{}\";5,0,1,Block{minecraft:dark_oak_log}[axis=x],\"{}\";1,0,5,Block{minecraft:dark_oak_log}[axis=z],\"{}\";6,0,1,Block{minecraft:polished_andesite},\"{}\";2,0,5,Block{minecraft:grass_block}[snowy=false],\"{}\";7,0,1,Block{minecraft:polished_andesite},\"{}\";3,0,5,Block{minecraft:stripped_birch_log}[axis=x],\"{}\";4,0,5,Block{minecraft:stripped_birch_log}[axis=x],\"{}\";5,0,5,Block{minecraft:grass_block}[snowy=false],\"{}\";6,2,6,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";6,0,5,Block{minecraft:dark_oak_log}[axis=z],\"{}\";7,0,5,Block{minecraft:grass_block}[snowy=false],\"{}\";1,1,1,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";1,3,6,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";6,1,1,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";6,3,6,Block{minecraft:stripped_oak_log}[axis=y],\"{}\";1,4,2,Block{minecraft:oak_log}[axis=z],\"{}\";"
			,
			"0,0,0,Block{minecraft:cobblestone},\"{}\";1,0,0,Block{minecraft:cobblestone},\"{}\";2,0,0,Block{minecraft:cobblestone},\"{}\";3,0,0,Block{minecraft:cobblestone},\"{}\";0,0,4,Block{minecraft:cobblestone},\"{}\";4,0,0,Block{minecraft:cobblestone},\"{}\";5,2,1,Block{minecraft:sticky_piston}[extended=false|facing=south],\"{}\";6,4,2,Block{minecraft:repeater}[delay=2|facing=south|locked=false|powered=false],\"{}\";1,0,4,Block{minecraft:cobblestone},\"{}\";5,0,0,Block{minecraft:cobblestone},\"{}\";6,2,1,Block{minecraft:sticky_piston}[extended=false|facing=south],\"{}\";2,0,4,Block{minecraft:cobblestone},\"{}\";6,0,0,Block{minecraft:cobblestone},\"{}\";7,0,0,Block{minecraft:cobblestone},\"{}\";3,0,4,Block{minecraft:cobblestone},\"{}\";5,4,6,Block{minecraft:redstone_wire}[east=side|north=none|power=0|south=none|west=none],\"{}\";4,0,4,Block{minecraft:cobblestone},\"{}\";6,4,6,Block{minecraft:redstone_wire}[east=none|north=side|power=0|south=none|west=side],\"{}\";5,2,5,Block{minecraft:polished_andesite},\"{}\";5,0,4,Block{minecraft:cobblestone},\"{}\";6,2,5,Block{minecraft:sticky_piston}[extended=false|facing=west],\"{}\";6,0,4,Block{minecraft:cobblestone},\"{}\";7,0,4,Block{minecraft:cobblestone},\"{}\";5,3,1,Block{minecraft:polished_andesite},\"{}\";6,3,1,Block{minecraft:polished_andesite},\"{}\";5,3,5,Block{minecraft:polished_andesite},\"{}\";6,3,5,Block{minecraft:polished_andesite},\"{}\";5,4,1,Block{minecraft:redstone_wire}[east=side|north=none|power=0|south=none|west=none],\"{}\";0,0,3,Block{minecraft:cobblestone},\"{}\";6,4,1,Block{minecraft:redstone_wire}[east=none|north=none|power=0|south=side|west=side],\"{}\";1,0,3,Block{minecraft:cobblestone},\"{}\";2,0,3,Block{minecraft:cobblestone},\"{}\";3,0,3,Block{minecraft:cobblestone},\"{}\";0,0,7,Block{minecraft:cobblestone},\"{}\";4,0,3,Block{minecraft:cobblestone},\"{}\";6,4,5,Block{minecraft:repeater}[delay=2|facing=north|locked=false|powered=false],\"{}\";1,0,7,Block{minecraft:cobblestone},\"{}\";5,0,3,Block{minecraft:cobblestone},\"{}\";2,0,7,Block{minecraft:cobblestone},\"{}\";6,0,3,Block{minecraft:cobblestone},\"{}\";3,0,7,Block{minecraft:cobblestone},\"{}\";7,0,3,Block{minecraft:cobblestone},\"{}\";4,0,7,Block{minecraft:cobblestone},\"{}\";5,0,7,Block{minecraft:cobblestone},\"{}\";6,0,7,Block{minecraft:cobblestone},\"{}\";7,0,7,Block{minecraft:cobblestone},\"{}\";5,3,4,Block{minecraft:polished_andesite},\"{}\";6,3,4,Block{minecraft:polished_andesite},\"{}\";0,0,2,Block{minecraft:cobblestone},\"{}\";1,0,2,Block{minecraft:cobblestone},\"{}\";2,0,2,Block{minecraft:cobblestone},\"{}\";3,0,2,Block{minecraft:cobblestone},\"{}\";0,0,6,Block{minecraft:cobblestone},\"{}\";4,0,2,Block{minecraft:cobblestone},\"{}\";6,4,4,Block{minecraft:redstone_wire}[east=none|north=side|power=0|south=side|west=none],\"{}\";1,0,6,Block{minecraft:cobblestone},\"{}\";5,0,2,Block{minecraft:cobblestone},\"{}\";2,0,6,Block{minecraft:cobblestone},\"{}\";6,0,2,Block{minecraft:cobblestone},\"{}\";3,0,6,Block{minecraft:cobblestone},\"{}\";7,0,2,Block{minecraft:cobblestone},\"{}\";4,0,6,Block{minecraft:cobblestone},\"{}\";5,0,6,Block{minecraft:cobblestone},\"{}\";6,0,6,Block{minecraft:cobblestone},\"{}\";7,0,6,Block{minecraft:cobblestone},\"{}\";5,3,3,Block{minecraft:polished_andesite},\"{}\";6,3,3,Block{minecraft:polished_andesite},\"{}\";5,1,2,Block{minecraft:polished_andesite},\"{}\";6,1,2,Block{minecraft:sticky_piston}[extended=false|facing=west],\"{}\";5,1,6,Block{minecraft:sticky_piston}[extended=false|facing=north],\"{}\";6,1,6,Block{minecraft:sticky_piston}[extended=false|facing=north],\"{}\";0,0,1,Block{minecraft:cobblestone},\"{}\";1,0,1,Block{minecraft:cobblestone},\"{}\";2,0,1,Block{minecraft:cobblestone},\"{}\";3,0,1,Block{minecraft:cobblestone},\"{}\";5,4,3,Block{minecraft:lever}[face=floor|facing=east|powered=false],\"{}\";0,0,5,Block{minecraft:cobblestone},\"{}\";4,0,1,Block{minecraft:cobblestone},\"{}\";6,4,3,Block{minecraft:redstone_wire}[east=none|north=side|power=0|south=side|west=side],\"{}\";5,2,2,Block{minecraft:polished_andesite},\"{}\";1,0,5,Block{minecraft:cobblestone},\"{}\";5,0,1,Block{minecraft:cobblestone},\"{}\";6,2,2,Block{minecraft:sticky_piston}[extended=false|facing=west],\"{}\";2,0,5,Block{minecraft:cobblestone},\"{}\";6,0,1,Block{minecraft:cobblestone},\"{}\";3,0,5,Block{minecraft:cobblestone},\"{}\";7,0,1,Block{minecraft:cobblestone},\"{}\";4,0,5,Block{minecraft:cobblestone},\"{}\";5,2,6,Block{minecraft:sticky_piston}[extended=false|facing=north],\"{}\";5,0,5,Block{minecraft:cobblestone},\"{}\";6,2,6,Block{minecraft:sticky_piston}[extended=false|facing=north],\"{}\";6,0,5,Block{minecraft:cobblestone},\"{}\";7,0,5,Block{minecraft:cobblestone},\"{}\";5,3,2,Block{minecraft:polished_andesite},\"{}\";5,1,1,Block{minecraft:sticky_piston}[extended=false|facing=south],\"{}\";6,3,2,Block{minecraft:polished_andesite},\"{}\";6,1,1,Block{minecraft:sticky_piston}[extended=false|facing=south],\"{}\";5,3,6,Block{minecraft:polished_andesite},\"{}\";6,3,6,Block{minecraft:polished_andesite},\"{}\";5,1,5,Block{minecraft:polished_andesite},\"{}\";6,1,5,Block{minecraft:sticky_piston}[extended=false|facing=west],\"{}\";"
	};
	
	final Random random;
	final int id;
	
	public Group(String label) {
		super(label);
		this.random = new Random();
		id = random.nextInt(strings.length);
	}
	
	public Group(int index, String label) {
		super(index, label);
		this.random = new Random();
		id = random.nextInt(strings.length);
	}
	
	@Override
	public ItemStack createIcon() {
		ItemStack stack = new ItemStack(Deferred.UNITITEM.get());
		CompoundNBT BlockEntityTag = new CompoundNBT();
		BlockEntityTag.putString("world", strings[id]);
		BlockEntityTag.putInt("upb", 8);
		stack.getOrCreateTag().put("BlockEntityTag", BlockEntityTag);
		return stack;
	}
	
	private static final Gson gson = new Gson();
	
	@Override
	public void fill(NonNullList<ItemStack> items) {
		super.fill(items);
		String text = "";
		try {
			InputStream stream = Group.class.getClassLoader().getResourceAsStream("smaller_units_default_tab/default_su_tab_items.json");
			byte[] bytes = new byte[stream.available()];
			stream.read(bytes);
			stream.close();
			text = new String(bytes);
		} catch (Throwable ignored) {
			return;
		}
		JsonObject object = gson.fromJson(text, JsonObject.class);
		JsonArray array = object.getAsJsonArray("list");
		for (int i = 0; i < array.size(); i++) {
			JsonObject object1 = (JsonObject) array.get(i);
			String file = object1.getAsJsonPrimitive("file").getAsString();
			String name = object1.getAsJsonPrimitive("name").getAsString();
			String author = object1.getAsJsonPrimitive("author").getAsString();
			ItemStack stack = new ItemStack(Deferred.UNITITEM.get());
			CompoundNBT itemNBT = stack.getOrCreateTag();
			CompoundNBT displayNBT = new CompoundNBT();
			ListNBT tooltip = new ListNBT();
			tooltip.add(StringNBT.valueOf("{\"text\":\"Author: " + author + "\"}"));
			displayNBT.put("Lore", tooltip);
			itemNBT.put("display", displayNBT);
			InputStream stream = Group.class.getClassLoader().getResourceAsStream("smaller_units_default_tab/" + file + ".nbt");
			try {
				itemNBT.put("BlockEntityTag", CompressedStreamTools.read(new DataInputStream(stream)));
				stream.close();
			} catch (Throwable ignored) {
			}
			items.add(stack);
			stack.setDisplayName(new StringTextComponent(name).mergeStyle(TextFormatting.AQUA));
		}
	}
}
