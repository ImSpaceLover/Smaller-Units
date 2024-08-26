package tfc.smallerunits.utils.vr.player.mods;
//TODO fix vivecraft compat
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.entity.player.Player;
//import org.joml.Quaternionf;
//import org.vivecraft.client_vr.VRData;
//import org.vivecraft.client_vr.gameplay.VRPlayer;
//import org.vivecraft.common.utils.math.Quaternion;
//import org.vivecraft.server.ServerVivePlayer;
//import tfc.smallerunits.utils.IHateTheDistCleaner;
//import tfc.smallerunits.utils.vr.player.SUVRPlayer;
//import tfc.smallerunits.utils.vr.player.VRController;
//
//public class Vivecraft {
//	public static SUVRPlayer getPlayerClient() {
//		VRPlayer player = VRPlayer.get();
//		if (player == null) return null;
//		IHateTheDistCleaner.updateCamera();
//		VRData data = player.vrdata_world_render;
//		VRData.VRDevicePose headP = data.getController(2); // I think this is the head???
//		VRController head = new VRController(headP.getPosition(), mojQuat(new Quaternion(headP.getMatrix())));
//		VRData.VRDevicePose mArmP = data.getController(0); // main arm
//		VRController mArm = new VRController(mArmP.getPosition(), mojQuat(new Quaternion(mArmP.getMatrix())));
//		VRData.VRDevicePose oArmP = data.getController(1); // second arm
//		VRController oArm = new VRController(oArmP.getPosition(), mojQuat(new Quaternion(oArmP.getMatrix())));
//		return new SUVRPlayer(data.worldScale, head, mArm, oArm);
//	}
//
//	protected static Quaternionf getQuatFrom(byte[] bytes) {
//		// had to trial&error this
//		// update: I have now looked at vivecraft's Quaternion class and this entirely makes sense now
//		return new Quaternionf(
//				readFloat(bytes, 17),
//				readFloat(bytes, 21),
//				readFloat(bytes, 25),
//				readFloat(bytes, 13)
//		);
//	}
//
//	public static SUVRPlayer getPlayerJRBudda(Player player) {
////		if (true) return null;
//
//		ServerVivePlayer vivePlayer = new ServerVivePlayer((ServerPlayer) player);
//		if (vivePlayer == null) return null;
//		if (!vivePlayer.isVR()) return null;
//		if (vivePlayer.getHMDDir() == null)
//			return null;
//
////		boolean flag = datainputstream.readBoolean();// 0
////		float f = datainputstream.readFloat();// 1
////		float f1 = datainputstream.readFloat();// 5
////		float f2 = datainputstream.readFloat();// 9
////		float f3 = datainputstream.readFloat();// 13
////		float f4 = datainputstream.readFloat();// 17
////		float f5 = datainputstream.readFloat();// 21
////		float f6 = datainputstream.readFloat();// 25
//
////		for (int i = 1; i < vivePlayer.hmdData.length; i++) {
////			System.out.print(vivePlayer.hmdData[i] + ", ");
////			if (i != 1 && (i - 1) % 4 == 0) System.out.println();
////		}
////		System.out.println();
////		if (true) return null;
//		VRController head = new VRController(
//				vivePlayer.getHMDPos(player),
//				getQuatFrom(vivePlayer.getHMDDir())
//		);
//		VRController mArm = new VRController(
//				vivePlayer.getControllerPos(0, player),
//				getQuatFrom(vivePlayer.controller0data)
//		);
//		VRController oArm = new VRController(
//				vivePlayer.getControllerPos(1, player),
//				getQuatFrom(vivePlayer.controller1data)
//		);
//		return new SUVRPlayer(vivePlayer.worldScale, head, mArm, oArm);
//	}
//
//	// https://stackoverflow.com/a/7619315
//	protected static float readFloat(byte[] bytes, int index) {
//		return Float.intBitsToFloat(((bytes[index] & 0xFF) << 24) | ((bytes[index + 1] & 0xFF) << 16) | ((bytes[index + 2] & 0xFF) << 8) | ((bytes[index + 3] & 0xFF)));
//	}
//
//	private static Quaternionf mojQuat(Quaternion quaternion) {
//		return new Quaternionf(quaternion.x, quaternion.y, quaternion.z, quaternion.w);
//	}
//
//	public static SUVRPlayer getOtherClient(Player player) {
//		PlayerModelController.RotInfo rotInfo = PlayerModelController.getInstance().getRotationsForPlayer(player.getUUID());
//		VRController head = new VRController(rotInfo.Headpos, mojQuat(rotInfo.headQuat));
//		VRController mArm = new VRController(rotInfo.rightArmPos, mojQuat(rotInfo.rightArmQuat));
//		VRController oArm = new VRController(rotInfo.leftArmPos, mojQuat(rotInfo.leftArmQuat));
//		return new SUVRPlayer(rotInfo.worldScale, head, mArm, oArm);
//	}
//}
//