package com.gokhantamkoc.javabootcamp.odevhafta2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlayWorldOfMagic implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(PlayWorldOfMagic.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int maxNumOfAttacksAllowed = 9;
		String[] magicianSpells = createSpellNameRepository();
		float[] spellDamageInfo = createSpellDamageRepository();
		String[] bossNames = createBossNameRepository();
		float[] bossHps = createBossHPRepository();
		
		int minNumberSpellsUsed = resolveBattle(
				magicianSpells, 
				spellDamageInfo, 
				bossNames, 
				bossHps);
		
		if (minNumberSpellsUsed > maxNumOfAttacksAllowed) {
			System.out.println("Magician died!");
		} else if (minNumberSpellsUsed > 0 && minNumberSpellsUsed <= maxNumOfAttacksAllowed) {
			System.out.println("Magician won the battle!");
		} else {
			System.out.println("Result is not correct!");
		}
	}

	public static int resolveBattle(
			String[] magicianSpells,
			float[] spellDamageInfo,
			String[] bossNames,
			float[] bossHPs
			) {



		int spellsUsed = 0;
		// ______ BASLANGIC _______ Kodunuz buradan baslamali
		float chosenSpell = spellDamageInfo[0];
		float totalHP;
		for (int i = 0; i<3; i++){  //3 canavar için yazılan döngü.
			for (int j = 0; j<2; j++) { //tek atışta canavarı öldüremeyen büyüler için tekrar döngüsü.
				totalHP = bossHPs[i] - chosenSpell;
				spellsUsed += 1;
				if(totalHP>0){
					totalHP-=chosenSpell;
					spellsUsed += 1;
				}
				if (totalHP <= 0) {
					break;
				}
			}
		}
		// ______ SON _______ Kodunuz burada bitmeli
		/* NOT: ______ BASLANGIC _______ ve ______ SON _______ 
		 * arasina istediginiz kadar sayida satir ekleyebilirsiniz.
		 */
		return spellsUsed;
	}
	
	public static String[] createSpellNameRepository() {
		return new String[]{"Ice Storm", "Chain Lightning", "Magic Missile"};
	}
	
	public static float[] createSpellDamageRepository() {
		return new float[]{40.0f, 30.0f, 5.0f};
	}
	
	public static String[] createBossNameRepository() {
		return new String[]{"Dire Rat", "Skeleton Knight", "Undead King"};
	}
	
	public static float[] createBossHPRepository() {
		return new float[]{15.0f, 45.0f, 60.0f};
	}
}
