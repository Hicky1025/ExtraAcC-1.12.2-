package cn.nulladev.extraacc.ability.aerohand.skill;

import cn.academy.ability.Skill;
import cn.academy.ability.context.ClientRuntime;
import cn.academy.ability.context.Context;
import cn.lambdalib2.s11n.network.NetworkMessage.Listener;
import cn.lambdalib2.util.MathUtils;
import cn.nulladev.extraacc.entity.EntityAirWall;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AirWall extends Skill {

	public static final AirWall INSTANCE = new AirWall();

	private AirWall() {
		super("air_wall", 3);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void activate(ClientRuntime rt, int keyID) {
		activateSingleKey2(rt, keyID, (EntityPlayer p) -> new ContextAirWall(p));
	}
	
	public static class ContextAirWall extends Context {
		
		static final String MSG_PERFORM = "perform";
		
		private float cp;

		public ContextAirWall(EntityPlayer _player) {
			super(_player, AirWall.INSTANCE);
			cp = MathUtils.lerpf(500, 300, ctx.getSkillExp());
		}
		
		private boolean consume() {
			float overload = MathUtils.lerpf(90, 60, ctx.getSkillExp());
			return ctx.consume(overload, cp);
		}
		
		@Listener(channel=MSG_KEYDOWN, side=Side.CLIENT)
		public void l_keydown()  {
			sendToServer(MSG_PERFORM);
		}
		
		@Listener(channel=MSG_PERFORM, side=Side.SERVER)
		public void s_perform()  {
			if(consume()) {
				World world = player.world;	
				EntityAirWall wall = new EntityAirWall(world, player, ctx.getSkillExp());
				world.spawnEntity(wall);
				ctx.addSkillExp(getExpIncr());
				ctx.setCooldown((int)MathUtils.lerpf(60, 40, ctx.getSkillExp()));
			}
		    terminate();
		}

		private float getExpIncr()  {
			return MathUtils.lerpf(0.02f, 0.01f, ctx.getSkillExp());
		}
			
	}


}