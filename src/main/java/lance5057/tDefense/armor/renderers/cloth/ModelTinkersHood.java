package lance5057.tDefense.armor.renderers.cloth;

import lance5057.tDefense.TinkersDefense;
import lance5057.tDefense.armor.ArmorCore;
import lance5057.tDefense.armor.renderers.ArmorRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelTinkersHood extends ArmorRenderer
{
	public ModelRenderer	Hood;
	public ModelRenderer	Flop;

	public ModelTinkersHood()
	{
		super(1.0f, 0, 64, 64);

		this.textureWidth = 64;
		this.textureHeight = 64;

		this.Hood = new ModelRenderer(this, 0, 44);
		this.Hood.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Hood.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
		this.bipedHead.addChild(this.Hood);

		this.Flop = new ModelRenderer(this, 0, 32);
		this.Flop.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Flop.addBox(-4.0F, -9.6F, 0.3F, 8, 8, 4, 0.0F);
		this.setRotateAngle(Flop, -0.4553564018453205F, 0.0F, 0.0F);
		this.bipedHead.addChild(this.Flop);

		this.bipedHeadwear.isHidden = true;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		GL11.glPushMatrix();

		for(int i = 0; i < 10; i++)
		{
			String texture = ((ArmorCore) this.stack.getItem()).getTexture(i, stack);
			if(texture != "")
			{

				GL11.glPushMatrix();

				((ArmorCore) this.stack.getItem()).renderArmor(entity, f, f1, f2, f3, f4, f5, colors, stack, i);
				super.render(entity, f, f1, f2, f3, f4, f5);

				GL11.glPopMatrix();
			}
		}

		GL11.glPopMatrix();
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
