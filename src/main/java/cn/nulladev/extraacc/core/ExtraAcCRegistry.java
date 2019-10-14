package cn.nulladev.extraacc.core;

import cn.academy.ability.RegCategory;
import cn.nulladev.extraacc.ability.aerohand.CatAeroHand;
import cn.nulladev.extraacc.client.render.RenderAirGun;
import cn.nulladev.extraacc.entity.EntityAirBlade;
import cn.nulladev.extraacc.entity.EntityAirCannon;
import cn.nulladev.extraacc.entity.EntityBomberLance;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ExtraAcCRegistry {
	
	@RegCategory
    public static final CatAeroHand aerohand = new CatAeroHand();
	
	public static void register(Object ModObject) {
		registerEntities(ModObject);
	}
	
	private static void registerEntities(Object ModObject) {
		int modID = 1;
    	EntityRegistry.registerModEntity(new ResourceLocation("extraacc:air_cannon"), EntityAirCannon.class, "air_cannon", modID++, ModObject, 128, 1, true);
    	EntityRegistry.registerModEntity(new ResourceLocation("extraacc:air_blade"), EntityAirBlade.class, "air_blade", modID++, ModObject, 128, 1, true);
    	EntityRegistry.registerModEntity(new ResourceLocation("extraacc:bomber_lance"), EntityBomberLance.class, "bomber_lance", modID++, ModObject, 128, 1, true);
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerClient() {

	}

}
