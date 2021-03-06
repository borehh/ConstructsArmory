package c4.conarm.integrations.crafttweaker.materials;

import c4.conarm.integrations.crafttweaker.actions.SetArmorAction;
import c4.conarm.integrations.crafttweaker.actions.SetDurabilityAction;
import c4.conarm.integrations.crafttweaker.actions.SetModifierAction;
import c4.conarm.lib.materials.ArmorMaterialType;
import c4.conarm.lib.materials.CoreMaterialStats;
import c4.conarm.lib.materials.PlatesMaterialStats;
import c4.conarm.lib.materials.TrimMaterialStats;
import crafttweaker.CraftTweakerAPI;
import slimeknights.tconstruct.library.materials.Material;

public class ConArmMaterial implements IConArmMaterial {

    private final Material material;

    public ConArmMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String getName() {
        return material.getIdentifier();
    }

    @Override
    public boolean matches(IConArmMaterial other) {
        return other.getName().equals(getName());
    }

    @Override
    public IConArmMatDefinition getDefinition() {
        return new ConArmMatDefinition(material);
    }

    @Override
    public Object getInternal() {
        return material;
    }

    @Override
    public void setDurabilityCore(float durability) {
        CraftTweakerAPI.apply(new SetDurabilityAction(this, ArmorMaterialType.CORE, durability));
    }

    @Override
    public float getDurabilityCore() {
        return ((CoreMaterialStats) material.getStats(ArmorMaterialType.CORE)).durability;
    }

    @Override
    public void setDurabilityPlates(float durability) {
        CraftTweakerAPI.apply(new SetDurabilityAction(this, ArmorMaterialType.PLATES, durability));
    }

    @Override
    public float getDurabilityPlates() {
        return ((PlatesMaterialStats) material.getStats(ArmorMaterialType.PLATES)).durability;
    }

    @Override
    public void setDurabilityTrim(float durability) {
        CraftTweakerAPI.apply(new SetDurabilityAction(this, ArmorMaterialType.TRIM, durability));
    }

    @Override
    public float getDurabilityTrim() {
        return ((TrimMaterialStats) material.getStats(ArmorMaterialType.TRIM)).extraDurability;
    }

    @Override
    public void setArmor(float[] armor) {
        CraftTweakerAPI.apply(new SetArmorAction(this, armor));
    }

    @Override
    public float[] getArmor() {
        return ((CoreMaterialStats) material.getStats(ArmorMaterialType.CORE)).armor;
    }

    @Override
    public void setModifier(float modifier) {
        CraftTweakerAPI.apply(new SetModifierAction(this, modifier));
    }

    @Override
    public float getModifier() {
        return ((PlatesMaterialStats) material.getStats(ArmorMaterialType.PLATES)).modifier;
    }

    @Override
    public void setToughness(float toughness) {
        CraftTweakerAPI.apply(new SetModifierAction(this, toughness));
    }

    @Override
    public float getToughness() {
        return ((PlatesMaterialStats) material.getStats(ArmorMaterialType.PLATES)).toughness;
    }
}
