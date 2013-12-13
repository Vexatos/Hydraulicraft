package pet.minecraft.Hydraulicraft.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHydraulicHose extends ModelBase
{
  //fields
    ModelRenderer hoseCorner;
    ModelRenderer hoseUp;
    ModelRenderer hoseDown;
    ModelRenderer hoseCenter;
    ModelRenderer hoseLeft;
    ModelRenderer hoseRight;
    ModelRenderer hoseFront;
    ModelRenderer hoseBack;
  
  public ModelHydraulicHose(){
    textureWidth = 64;
    textureHeight = 32;
    
      hoseCorner = new ModelRenderer(this, 0, 9);
      hoseCorner.addBox(-3F, -3F, -3F, 6, 6, 6);
      hoseCorner.setRotationPoint(0F, 16F, 0F);
      hoseCorner.setTextureSize(64, 32);
      hoseCorner.mirror = true;
      setRotation(hoseCorner, 0F, 0F, 0F);
      hoseUp = new ModelRenderer(this, 0, 0);
      hoseUp.addBox(-2F, 0F, -2F, 4, 5, 4);
      hoseUp.setRotationPoint(0F, 8F, 0F);
      hoseUp.setTextureSize(64, 32);
      hoseUp.mirror = true;
      setRotation(hoseUp, 0F, 0F, 0F);
      hoseDown = new ModelRenderer(this, 0, 0);
      hoseDown.addBox(-2F, 0F, -2F, 4, 5, 4);
      hoseDown.setRotationPoint(0F, 24F, 0F);
      hoseDown.setTextureSize(64, 32);
      hoseDown.mirror = true;
      setRotation(hoseDown, 3.141593F, 0F, 0F);
      hoseCenter = new ModelRenderer(this, 16, 0);
      hoseCenter.addBox(-2F, -2F, -2F, 4, 4, 4);
      hoseCenter.setRotationPoint(0F, 16F, 0F);
      hoseCenter.setTextureSize(64, 32);
      hoseCenter.mirror = true;
      setRotation(hoseCenter, 0F, 0F, 0F);
      hoseLeft = new ModelRenderer(this, 0, 0);
      hoseLeft.addBox(-2F, 0F, -2F, 4, 5, 4);
      hoseLeft.setRotationPoint(-3F, 16F, 0F);
      hoseLeft.setTextureSize(64, 32);
      hoseLeft.mirror = true;
      setRotation(hoseLeft, 0F, 0F, 1.570796F);
      hoseRight = new ModelRenderer(this, 0, 0);
      hoseRight.addBox(-2F, 0F, -2F, 4, 5, 4);
      hoseRight.setRotationPoint(3F, 16F, 0F);
      hoseRight.setTextureSize(64, 32);
      hoseRight.mirror = true;
      setRotation(hoseRight, 0F, 0F, -1.570796F);
      hoseFront = new ModelRenderer(this, 0, 0);
      hoseFront.addBox(-2F, 0F, -2F, 4, 5, 4);
      hoseFront.setRotationPoint(0F, 16F, -3F);
      hoseFront.setTextureSize(64, 32);
      hoseFront.mirror = true;
      setRotation(hoseFront, 0F, -1.570796F, 1.570796F);
      hoseBack = new ModelRenderer(this, 0, 0);
      hoseBack.addBox(-2F, 0F, -2F, 4, 5, 4);
      hoseBack.setRotationPoint(0F, 16F, 3F);
      hoseBack.setTextureSize(64, 32);
      hoseBack.mirror = true;
      setRotation(hoseBack, 0F, 1.570796F, 1.570796F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    hoseCorner.render(f5);
    hoseUp.render(f5);
    hoseDown.render(f5);
    hoseCenter.render(f5);
    hoseLeft.render(f5);
    hoseRight.render(f5);
    hoseFront.render(f5);
    hoseBack.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z){
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity){
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}