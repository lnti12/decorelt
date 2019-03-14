package ru.lnti.elterionrpg.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraftforge.fml.relauncher.ReflectionHelper;
import ru.lnti.elterionrpg.elterionrpg;

import com.google.common.base.Joiner;



public class RpgInventoryUtils{

	/**
	 * It allows you to change the final field
	 *
	 * @param field Field to modify
	 *
	 * @return True if modify
	 */
	public static boolean modifyFieldToFinal(Field field){
		try{
			if(field != null){
				Field modfield = Field.class.getDeclaredField("modifiers");
				modfield.setAccessible(true);
				modfield.setInt(field, field.getModifiers() & ~Modifier.FINAL);
				return true;
			}
		}catch(ReflectiveOperationException e){
			elterionrpg.logger.error("Failed to modify field with name " + field.getName() + " to final in class " + field.getDeclaringClass().getSimpleName());
		}

		return false;
	}

	/**
	 * Setting private value in class
	 *
	 * @param clazz Class of field
	 * @param instance Instance of the clazz
	 * @param value New field value
	 * @param names Field name
	 *
	 * @return True if setting
	 */
	public static <I, V> boolean setPrivateValue(Class<?> clazz, I instance, V value, String... names){
		try{
			Field field = ReflectionHelper.findField(clazz, names);
			if(Modifier.isFinal(field.getModifiers())){
				modifyFieldToFinal(field);
			}
			field.set(instance, value);
			return true;
		}catch(ReflectiveOperationException e){
			elterionrpg.logger.error("Failed to set private value in field with name " + "[" + Joiner.on("or ").join(names) + "]" + " in class " + clazz.getSimpleName());
		}

		return false;
	}
}