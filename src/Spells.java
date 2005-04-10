public class Spells
{
	private String [] spells = new String[0];
	
	public Spells (int cla, int level)
	{
		if (cla == 0) //[0]Fighter 
		{
			if (level == 2)
			{
				this.add("Emissarius Nex (6 mp)");
			}
			else if (level == 3)
			{
				this.add("Double Slice (3 mp)");
			}
			else if (level == 4)
			{
				this.add("Minor Mederi (2 mp)");
				this.add("Nocte Visus (4 mp)");
			}
			else if (level == 5)
			{
				this.add("Minor Sanatio (3 mp)");
				this.add("Minor Tueri (3 mp)");
				this.add("Emissarius (6 mp)");
				this.add("Double Stab (8 mp)");
			}
			else if (level == 6)
			{
				this.add("Minor Flamma (3 mp)");
				this.add("Minor Stupefacere (3 mp)");
				this.add("Minor Velocitas (7 mp)");
				this.add("Nonne Sera (7 mp)");
			}
			else if (level == 7)
			{
				this.add("Tiron Tueri (5 mp)");
				this.add("Minor Robur (8 mp)");
			}
			else if (level == 8)
			{
				this.add("Tiron Stupefacere (5 mp)");
				this.add("Shield Bash (12 mp)");
				this.add("Mutatio Nimbus (12 mp)");
				this.add("Contra Magicus (16 mp)");
			}
			else if (level == 9)
			{
				this.add("Tiron Robur (10 mp)");
				this.add("Minor Extrudere (13 mp)");
				this.add("Contra Visus (18 mp)");
			}
			else if (level == 10)
			{
				this.add("Tiron Sanatio (6 mp)");
			}
			else if (level == 11)
			{
				this.add("Medius Stupefacere (15 mp)");
				this.add("Medius Tueri (15 mp)");
			}
			else if (level == 12)
			{
				this.add("Back Spin (15 mp)");
				this.add("Medius Robur (15 mp)");
			}
			else if (level == 13)
			{
				this.add("Medius Mederi (12 mp)");
				this.add("Sensus Scientia (13 mp)");
				this.add("Tiron Extrudere (18 mp)");
			}
			else if (level == 15)
			{
				this.add("Attack Run Minor (1 mp)");
				this.add("Magna Sanatio (10 mp)");
				this.add("Magna Tueri (35 mp)");
			}
			else if (level == 16)
			{
				this.add("Minor Spin (5 mp)");
				this.add("Medius Velocitas (7 mp)");
			}
			else if (level == 17)
			{
				this.add("Attack Run Tiron (2 mp)");
				this.add("Jump attack (20 mp)");
			}
			else if (level == 18)
			{
				this.add("Tiron Spin (10 mp)");
			}
			else if (level == 20)
			{
				this.add("Attack Run Medius (3 mp)");
			}
			else if (level == 21)
			{
				this.add("Medius Spin (15 mp)");
				this.add("Maximus Tueri (60 mp)");
			}
			else if (level == 23)
			{
				this.add("Stab & Slice (25 mp)");
			}
			else if (level == 24)
			{
				this.add("Attack Run Magna (5 mp)");
			}
			else if (level == 25)
			{
				this.add("Magna Spin (20 mp)");
			}
			else if (level == 27)
			{
				this.add("Ultim Tueri (100 mp)");
			}
			else if (level == 29)
			{
				this.add("Attack Run Maximus (10 mp)");
			}
			else if (level == 30)
			{
				this.add("Maximus Spin (25 mp)");
				this.add("Bash & Stab (30 mp)");
			}
			else if (level == 34)
			{
				this.add("Vis Tueri (150 mp)");
			}
			else if (level == 35)
			{
				this.add("Attack Run Ultim (15 mp)");
			}
			else if (level == 36)
			{
				this.add("Ultim Spin (30 mp)");
			}
			else if (level == 38)
			{
				this.add("Tornado Slice (35 mp)");
			}
			else if (level == 42)
			{
				this.add("Attack Run Ferocia (20 mp)");
			}
			else if (level == 43)
			{
				this.add("Ferocia Spin (35 mp)");
				this.add("Infinitus Tueri (200 mp)");
			}
			else if (level == 50)
			{
				this.add("Attack Run Infinitus (25 mp)");
			}
			else if (level == 51)
			{
				this.add("Infinitus Spin (40 mp)");
			}
			else if (level == 52)
			{
				this.add("Omni Tueri (250 mp)");
			}
			else if (level == 59)
			{
				this.add("Attack Run Omni (30 mp)");
			}
			else if (level == 60)
			{
				this.add("Omni Spin (45 mp)");
			}
			else if (level == 62)
			{
				this.add("Divinus Tueri (320 mp)");
			}
			else if (level == 69)
			{
				this.add("Attack Run Dirus (35 mp)");
			}
			else if (level == 70)
			{
				this.add("Dirus Spin (50 mp)");
			}
			else if (level == 75)
			{
				this.add("Adept Tueri (400 mp)");
			}
			else if (level == 81)
			{
				this.add("Attack Run Adept (40 mp)");
			}
			else if (level == 82)
			{
				this.add("Adept Spin (55 mp)");
			}
		}
		else if (cla == 1) //[1]Ranger 
		{
			if (level == 1)
			{
				this.add("Hide Skill (0 mp)");
			}
			else if (level == 2)
			{
				this.add("Emissarius Nex (6 mp)");
			}
			else if (level == 3)
			{
				this.add("Double Slice (3 mp)");
			}
			else if (level == 4)
			{
				this.add("Minor Mederi (2 mp)");
				this.add("Nocte Visus (4 mp)");
			}
			else if (level == 5)
			{
				this.add("Minor Sanatio (3 mp)");
				this.add("Minor Tueri (3 mp)");
				this.add("Emissarius (6 mp)");
				this.add("Double Stab (8 mp)");
			}
			else if (level == 6)
			{
				this.add("Minor Flamma (3 mp)");
				this.add("Minor Stupefacere (3 mp)");
				this.add("Minor Velocitas (7 mp)");
				this.add("Nonne Sera (7 mp)");
			}
			else if (level == 7)
			{
				this.add("Tiron Tueri (5 mp)");
				this.add("Minor Robur (8 mp)");
			}
			else if (level == 8)
			{
				this.add("Tiron Stupefacere (5 mp)");
				this.add("Mutatio Nimbus (12 mp)");
				this.add("Multi Shot (15 mp)");
				this.add("Contra Magicus (16 mp)");
			}
			else if (level == 9)
			{
				this.add("Tiron Robur (10 mp)");
				this.add("Minor Extrudere (13 mp)");
				this.add("Contra Visus (18 mp)");
			}
			else if (level == 10)
			{
				this.add("Tiron Sanatio (6 mp)");
				this.add("Medius Tueri (15 mp)");
			}
			else if (level == 11)
			{
				this.add("Medius Stupefacere (15 mp)");
			}
			else if (level == 12)
			{
				this.add("Back Spin (15 mp)");
				this.add("Medius Robur (15 mp)");
			}
			else if (level == 13)
			{
				this.add("Medius Mederi (12 mp)");
				this.add("Sensus Scientia (13 mp)");
				this.add("Tiron Extrudere (18 mp)");
			}
			else if (level == 14)
			{
				this.add("Magna Tueri (35 mp)");
			}
			else if (level == 15)
			{
				this.add("Attack Run Minor (1 mp)");
				this.add("Magna Sanatio (10 mp)");
			}
			else if (level == 16)
			{
				this.add("Medius Velocitas (7 mp)");
			}
			else if (level == 17)
			{
				this.add("Attack Run Tiron (2 mp)");
				this.add("Jump attack (20 mp)");
			}
			else if (level == 19)
			{
				this.add("Maximus Tueri (60 mp)");
			}
			else if (level == 20)
			{
				this.add("Attack Run Medius (3 mp)");
			}
			else if (level == 23)
			{
				this.add("Stab & Slice (25 mp)");
			}
			else if (level == 24)
			{
				this.add("Attack Run Magna (5 mp)");
			}
			else if (level == 25)
			{
				this.add("Ultim Tueri (100 mp)");
			}
			else if (level == 29)
			{
				this.add("Attack Run Maximus (10 mp)");
			}
			else if (level == 32)
			{
				this.add("Vis Tueri (150 mp)");
			}
			else if (level == 35)
			{
				this.add("Attack Run Ultim (15 mp)");
			}
			else if (level == 38)
			{
				this.add("Tornado Slice (35 mp)");
			}
			else if (level == 40)
			{
				this.add("Infinitus Tueri (200 mp)");
			}
			else if (level == 42)
			{
				this.add("Attack Run Ferocia (20 mp)");
			}
			else if (level == 49)
			{
				this.add("Omni Tueri (250 mp)");
			}
			else if (level == 50)
			{
				this.add("Attack Run Infinitus (25 mp)");
			}
			else if (level == 59)
			{
				this.add("Attack Run Omni (30 mp)");
				this.add("Divinus Tueri (320 mp)");
			}
			else if (level == 69)
			{
				this.add("Attack Run Dirus (35 mp)");
			}
			else if (level == 71)
			{
				this.add("Adept Tueri (400 mp)");
			}
			else if (level == 81)
			{
				this.add("Attack Run Adept (40 mp)");
			}
		}
		else if (cla == 2) //[2]Paladin
		{
			if (level == 1)
			{
				this.add("Minor Mederi (2 mp)");
			}
			else if (level == 2)
			{
				this.add("Minor Incantare (3 mp)");
				this.add("Minor Sanatio (3 mp)");
				this.add("Minor Tueri (3 mp)");
				this.add("Emissarius (6 mp)");
				this.add("Emissarius Nex (6 mp)");
				this.add("Obstare Malus (6 mp)");
			}
			else if (level == 3)
			{
				this.add("Double Slice (3 mp)");
				this.add("Minor Stupefacere (3 mp)");
				this.add("Minor Velocitas (7 mp)");
				this.add("Nonne Sera (7 mp)");
			}
			else if (level == 4)
			{
				this.add("Nocte Visus (4 mp)");
				this.add("Tiron Incantare (5 mp)");
				this.add("Tiron Tueri (5 mp)");
				this.add("Medius Mederi (12 mp)");
			}
			else if (level == 5)
			{
				this.add("Minor Omnimultum (3 mp)");
				this.add("Tiron Stupefacere (5 mp)");
				this.add("Tiron Sanatio (6 mp)");
				this.add("Double Stab (8 mp)");
				this.add("Contra Magicus (16 mp)");
			}
			else if (level == 6)
			{
				this.add("Minor Flamma (3 mp)");
				this.add("Minor Extrudere (13 mp)");
				this.add("Contra Visus (18 mp)");
			}
			else if (level == 7)
			{
				this.add("Minor Robur (8 mp)");
				this.add("Tiron Omnimultum (8 mp)");
				this.add("Medius Tueri (15 mp)");
			}
			else if (level == 8)
			{
				this.add("Magna Sanatio (10 mp)");
				this.add("Mutatio Nimbus (12 mp)");
				this.add("Shield Bash (12 mp)");
				this.add("Medius Incantare (15 mp)");
				this.add("Medius Stupefacere (15 mp)");
				this.add("Sensus Probus (17 mp)");
				this.add("Magna Mederi (30 mp)");
			}
			else if (level == 9)
			{
				this.add("Tiron Robur (10 mp)");
			}
			else if (level == 10)
			{
				this.add("Medius Omnimultum (15 mp)");
				this.add("Tiron Extrudere (18 mp)");
				this.add("Sensus Scientia (13 mp)");
			}
			else if (level == 11)
			{
				this.add("Magnus Sanatio (25 mp)");
			}
			else if (level == 12)
			{
				this.add("Back Spin (15 mp)");
				this.add("Medius Robur (15 mp)");
				this.add("Pergere Trans (24 mp)");
				this.add("Magna Tueri (35 mp)");
				this.add("Vis Mederi (85 mp)");
			}
			else if (level == 14)
			{
				this.add("Magna Omnimultum (25 mp)");
			}
			else if (level == 15)
			{
				this.add("Attack Run Minor (1 mp)");
				this.add("Medius Extrudere (26 mp)");
			}
			else if (level == 16)
			{
				this.add("Medius Velocitas (7 mp)");
				this.add("Ultim Sanatio (60 mp)");
			}
			else if (level == 17)
			{
				this.add("Attack Run Tiron (2 mp)");
				this.add("Jump attack (20 mp)");
				this.add("Maximus Tueri (60 mp)");
			}
			else if (level == 19)
			{
				this.add("Minor Spin (5 mp)");
				this.add("Maximus Omnimultum (35 mp)");
			}
			else if (level == 20)
			{
				this.add("Attack Run Medius (3 mp)");
			}
			else if (level == 21)
			{
				this.add("Tiron Spin (10 mp)");
				this.add("Magna Extrudere (35 mp)");
			}
			else if (level == 23)
			{
				this.add("Stab & Slice (25 mp)");
				this.add("Ultim Tueri (100 mp)");
			}
			else if (level == 24)
			{
				this.add("Attack Run Magna (5 mp)");
				this.add("Medius Spin (15 mp)");
			}
			else if (level == 25)
			{
				this.add("Ultim Omnimultum (50 mp)");
			}
			else if (level == 28)
			{
				this.add("Magna Spin (20 mp)");
				this.add("Maximus Extrudere (60 mp)");
			}
			else if (level == 29)
			{
				this.add("Attack Run Maximus (10 mp)");
			}
			else if (level == 30)
			{
				this.add("Bash & Stab (30 mp)");
			}
			else if (level == 31)
			{
				this.add("Vis Tueri (150 mp)");
			}
			else if (level == 32)
			{
				this.add("Vis Omnimultum (70 mp)");
			}
			else if (level == 33)
			{
				this.add("Maximus Spin (25 mp)");
			}
			else if (level == 35)
			{
				this.add("Attack Run Ultim (15 mp)");
			}
			else if (level == 38)
			{
				this.add("Tornado Slice (35 mp)");
			}
			else if (level == 39)
			{
				this.add("Ultim Spin (30 mp)");
				this.add("Infinitus Tueri (200 mp)");
			}
			else if (level == 40)
			{
				this.add("Animus Omnimultum (90 mp)");
			}
			else if (level == 42)
			{
				this.add("Attack Run Ferocia (20 mp)");
			}
			else if (level == 46)
			{
				this.add("Ferocia Spin (35 mp)");
			}
			else if (level == 48)
			{
				this.add("Omni Tueri (250 mp)");
			}
			else if (level == 49)
			{
				this.add("Infinitus Omnimultum (120 mp)");
			}
			else if (level == 50)
			{
				this.add("Attack Run Infinitus (25 mp)");
			}
			else if (level == 54)
			{
				this.add("Infinitus Spin (40 mp)");
			}
			else if (level == 59)
			{
				this.add("Attack Run Omni (30 mp)");
				this.add("Divinus Omnimultum (150 mp)");
				this.add("Divinus Tueri (320 mp)");
			}
			else if (level == 63)
			{
				this.add("Omni Spin (45 mp)");
			}
			else if (level == 69)
			{
				this.add("Attack Run Dirus (35 mp)");
			}
			else if (level == 71)
			{
				this.add("Adept Omnimultum (200 mp)");
				this.add("Adept Tueri (400 mp)");
			}
			else if (level == 73)
			{
				this.add("Dirus Spin (50 mp)");
			}
			else if (level == 81)
			{
				this.add("Attack Run Adept (40 mp)");
			}
			else if (level == 85)
			{
				this.add("Adept Spin (55 mp)");
			}
		}
		else if (cla == 3) //[3]Cleric
		{
			if (level == 1)
			{
				this.add("Minor Mederi (2 mp)");
			}
			else if (level == 2)
			{
				this.add("Minor Incantare (3 mp)");
				this.add("Minor Flamma (3 mp)");
				this.add("Minor Sanatio (3 mp)");
				this.add("Minor Tueri (3 mp)");
				this.add("Emissarius (6 mp)");
				this.add("Emissarius Nex  (6 mp)");
				this.add("Obstare Malus (6 mp)");
			}
			else if (level == 3)
			{
				this.add("Minor Stupefacere (3 mp)");
				this.add("Minor Velocitas (7 mp)");
				this.add("Nonne Sera (7 mp)");
			}
			else if (level == 4)
			{
				this.add("Nocte Visus (4 mp)");
				this.add("Tiron Incantare (5 mp)");
				this.add("Tiron Tueri (5 mp)");
				this.add("Minor Glacialis Viscera (8 mp)");
				this.add("Medius Mederi (12 mp)");
			}
			else if (level == 5)
			{
				this.add("Tiron Stupefacere (5 mp)");
				this.add("Tiron Sanatio (6 mp)");
				this.add("Contra Magicus (16 mp)");
				this.add("Sensus Probus (17 mp)");
			}
			else if (level == 6)
			{
				this.add("Tiron Glacialis Viscera (10 mp)");
				this.add("Minor Extrudere (13 mp)");
				this.add("Contra Visus (18 mp)");
				this.add("Minor Fulgur (20 mp)");
			}
			else if (level == 7)
			{
				this.add("Minor Robur (8 mp)");
				this.add("Medius Tueri (15 mp)");
				this.add("Minor Glacialis Ventus (23 mp)");
				this.add("Arcessere Flamma (24 mp)");
			}
			else if (level == 8)
			{
				this.add("Magna Sanatio (10 mp)");
				this.add("Mutatio Nimbus (12 mp)");
				this.add("Medius Incantare (15 mp)");
				this.add("Medius Stupefacere (15 mp)");
				this.add("Tiron Extrudere (18 mp)");
				this.add("Tiron Fulgur (25 mp)");
				this.add("Magna Mederi (30 mp)");
				this.add("Minor Adgredi Animus (50 mp)");
			}
			else if (level == 9)
			{
				this.add("Tiron Robur (10 mp)");
				this.add("Medius Glacialis Viscera (15 mp)");
				this.add("Os Saltare (21 mp)");
				this.add("Tiron Glacialis Ventus (30 mp)");
			}
			else if (level == 10)
			{
				this.add("Sensus Scientia (13 mp)");
				this.add("Tiron Adgredi Animus (55 mp)");
			}
			else if (level == 11)
			{
				this.add("Magnus Sanatio (25 mp)");
				this.add("Medius Extrudere (26 mp)");
				this.add("Medius Fulgur (35 mp)");
				this.add("Creare Porta (85 mp)");
			}
			else if (level == 12)
			{
				this.add("Medius Robur (15 mp)");
				this.add("Pergere Trans (24 mp)");
				this.add("Magna Incantare (35 mp)");
				this.add("Magna Tueri (35 mp)");
				this.add("Medius Glacialis Ventus (40 mp)");
				this.add("Vis Mederi (85 mp)");
			}
			else if (level == 13)
			{
				this.add("Magnus Almus (0 mp)");
				this.add("Magna Glacialis Viscera (35 mp)");
				this.add("Medius Adgredi Animus (65 mp)");
			}
			else if (level == 15)
			{
				this.add("Magna Extrudere (35 mp)");
				this.add("Magna Fulgur (48 mp)");
			}
			else if (level == 16)
			{
				this.add("Medius Velocitas (7 mp)");
				this.add("Magna Robur (35 mp)");
				this.add("Magna Glacialis Ventus (50 mp)");
				this.add("Ultim Sanatio (60 mp)");
			}
			else if (level == 17)
			{
				this.add("Maximus Tueri (60 mp)");
				this.add("Magna Adgredi Animus (75 mp)");
			}
			else if (level == 18)
			{
				this.add("Maximus Incantare (60 mp)");
			}
			else if (level == 19)
			{
				this.add("Maximus Glacialis Viscera (60 mp)");
			}
			else if (level == 20)
			{
				this.add("Maximus Extrudere (60 mp)");
				this.add("Maximus Fulgur (60 mp)");
				this.add("Infinitus Mederi (120 mp)");
			}
			else if (level == 21)
			{
				this.add("Maximus Glacialis Ventus (60 mp)");
				this.add("Maximus Robur (60 mp)");
			}
			else if (level == 22)
			{
				this.add("Maximus Adgredi Animus (90 mp)");
			}
			else if (level == 23)
			{
				this.add("Ultim Tueri (100 mp)");
			}
			else if (level == 24)
			{
				this.add("Ultim Glacialis Viscera (100 mp)");
				this.add("Ultim Incantare (100 mp)");
				this.add("Animus Sanatio (150 mp)");
			}
			else if (level == 26)
			{
				this.add("Ultim Extrudere (100 mp)");
				this.add("Ultim Fulgur (100 mp)");
			}
			else if (level == 27)
			{
				this.add("Ultim Glacialis Ventus (100 mp)");
				this.add("Ultim Robur (100 mp)");
			}
			else if (level == 28)
			{
				this.add("Ultim Adgredi Animus (105 mp)");
			}
			else if (level == 30)
			{
				this.add("Praesentis Trans (200 mp)");
			}
			else if (level == 31)
			{
				this.add("Ferocia Glacialis Viscera (150 mp)");
				this.add("Vis Tueri (150 mp)");
			}
			else if (level == 32)
			{
				this.add("Ferocia Fulgur (150 mp)");
			}
			else if (level == 33){
				this.add("Animus Extrudere (150 mp)");
			}
			else if (level == 34)
			{
				this.add("Animus Robur (150 mp)");
				this.add("Ferocia Glacialis Ventus (150 mp)");
			}
			else if (level == 35)
			{
				this.add("Vis Adgredi Animus (150 mp)");
				this.add("Infinitus Sanatio (220 mp)");
			}
			else if (level == 39)
			{
				this.add("Infinitus Glacialis Viscera (200 mp)");
				this.add("Infinitus Tueri (200 mp)");
			}
			else if (level == 40)
			{
				this.add("Omni Mederi (230 mp)");
			}
			else if (level == 41)
			{
				this.add("Infinitus Extrudere (200 mp)");
				this.add("Infinitus Fulgur (200 mp)");
			}
			else if (level == 42)
			{
				this.add("Infinitus Glacialis Ventus (200 mp)");
			}
			else if (level == 43)
			{
				this.add("Infinitus Adgredi Animus (200 mp)");
			}
			else if (level == 45)
			{
				this.add("Omni Sanatio (260 mp)");
			}
			else if (level == 48)
			{
				this.add("Omni Glacialis Viscera (250 mp)");
				this.add("Omni Tueri (250 mp)");
			}
			else if (level == 50)
			{
				this.add("Omni Extrudere (250 mp)");
				this.add("Omni Fulgur (250 mp)");
			}
			else if (level == 51)
			{
				this.add("Omni Glacialis Ventus (250 mp)");
			}
			else if (level == 52)
			{
				this.add("Omni Adgredi Animus (250 mp)");
			}
			else if (level == 55)
			{
				this.add("Divinus Sanatio (350 mp)");
			}
			else if (level == 58)
			{
				this.add("Dirus Glacialis Viscera (320 mp)");
			}
			else if (level == 59)
			{
				this.add("Divinus Tueri (320 mp)");
			}
			else if (level == 60)
			{
				this.add("Divinus Mederi (300 mp)");
				this.add("Dirus Fulgur (320 mp)");
				this.add("Divinus Extrudere (320 mp)");
			}
			else if (level == 61)
			{
				this.add("Dirus Glacialis Ventus (320 mp)");
			}
			else if (level == 62)
			{
				this.add("Dirus Adgredi Animus (320 mp)");
			}
			else if (level == 65)
			{
				this.add("Adept Sanatio (450 mp)");
			}
			else if (level == 68)
			{
				this.add("Adept Mederi (450 mp)");
			}
			else if (level == 70)
			{
				this.add("Adept Glacialis Viscera (400 mp)");
			}
			else if (level == 71)
			{
				this.add("Adept Tueri (400 mp)");
			}
			else if (level == 72)
			{
				this.add("Adept Extrudere (400 mp)");
				this.add("Adept Fulgur (400 mp)");
			}
			else if (level == 73)
			{
				this.add("Adept Glacialis Ventus (400 mp)");
			}
			else if (level == 74)
			{
				this.add("Adept Adgredi Animus (400 mp)");
			}
		}
		else if (cla == 4) //[4]Wizard
		{
			if (level == 1)
			{
				this.add("Minor Adgredi (2 mp)");
			}
			else if (level == 2)
			{
				this.add("Minor Tueri (3 mp)");
				this.add("Minor Flamma (3 mp)");
				this.add("Emissarius (6 mp)");
				this.add("Emissarius Nex (6 mp)");
			}
			else if (level == 3)
			{
				this.add("Minor Ignis (3 mp)");
				this.add("Minor Stupefacere (3 mp)");
				this.add("Tiron Adgredi (4 mp)");
				this.add("Minor Velocitas (7 mp)");
				this.add("Nonne Sera (7 mp)");
			}
			else if (level == 4)
			{
				this.add("Minor Mederi (2 mp)");
				this.add("Nocte Visus (4 mp)");
				this.add("Tiron Tueri (5 mp)");
			}
			else if (level == 5)
			{
				this.add("Minor Sanatio (3 mp)");
				this.add("Tiron Ignis (5 mp)");
				this.add("Tiron Stupefacere (5 mp)");
				this.add("Minor Flamma Ventus (10 mp)");
				this.add("Contra Magicus (16 mp)");
			}
			else if (level == 6)
			{
				this.add("Medius Adgredi (8 mp)");
				this.add("Minor Extrudere (13 mp)");
				this.add("Contra Visus (18 mp)");
				this.add("Minor Noxa Tueri (50 mp)");
			}
			else if (level == 7)
			{
				this.add("Minor Robur (8 mp)");
				this.add("Tiron Flamma Ventus (15 mp)");
				this.add("Medius Tueri (15 mp)");
				this.add("Arcessere Flamma (24 mp)");
			}
			else if (level == 8)
			{
				this.add("Mutatio Nimbus (12 mp)");
				this.add("Medius Ignis (15 mp)");
				this.add("Medius Stupefacere (15 mp)");
				this.add("Tiron Extrudere (18 mp)");
				this.add("Tiron Noxa Tueri (55 mp)");
			}
			else if (level == 9)
			{
				this.add("Tiron Robur (10 mp)");
				this.add("Os Saltare (21 mp)");
				this.add("Multi Minor Nex (35 mp)");
			}
			else if (level == 10)
			{
				this.add("Tiron Sanatio (6 mp)");
				this.add("Magna Adgredi (12 mp)");
				this.add("Sensus Scientia (13 mp)");
				this.add("Medius Flamma Ventus (20 mp)");
				this.add("Minor Radius (35 mp)");
			}
			else if (level == 11)
			{
				this.add("Medius Extrudere (26 mp)");
				this.add("Magna Tueri (35 mp)");
				this.add("Multi Tiron Nex (40 mp)");
				this.add("Medius Noxa Tueri (65 mp)");
				this.add("Creare Porta (85 mp)");
			}
			else if (level == 12)
			{
				this.add("Medius Robur (15 mp)");
				this.add("Pergere Trans (24 mp)");
				this.add("Magna Ignis (35 mp)");
				this.add("Magna Stupefacere (35 mp)");
				this.add("Tiron Radius (45 mp)");
			}
			else if (level == 13)
			{
				this.add("Medius Velocitas (7 mp)");
				this.add("Medius Mederi (12 mp)");
			}
			else if (level == 14)
			{
				this.add("Magna Flamma Ventus (35 mp)");
				this.add("Multi Medius Nex (50 mp)");
			}
			else if (level == 15)
			{
				this.add("Magna Sanatio (10 mp)");
				this.add("Maximus Adgredi (17 mp)");
				this.add("Magna Extrudere (35 mp)");
				this.add("Medius Radius (55 mp)");
				this.add("Magna Noxa Tueri (75 mp)");
			}
			else if (level == 16)
			{
				this.add("Maximus Tueri (60 mp)");
			}
			else if (level == 17)
			{
				this.add("Maximus Ignis (60 mp)");
				this.add("Maximus Stupefacere (60 mp)");
			}
			else if (level == 18)
			{
				this.add("Multi Magna Nex (60 mp)");
			}
			else if (level == 19)
			{
				this.add("Maximus Flamma Ventus (60 mp)");
				this.add("Magna Radius (65 mp)");
			}
			else if (level == 20)
			{
				this.add("Maximus Extrudere (60 mp)");
				this.add("Maximus Noxa Tueri (90 mp)");
			}
			else if (level == 21)
			{
				this.add("Ultim Adgredi (30 mp)");
			}
			else if (level == 22)
			{
				this.add("Ultim Tueri (100 mp)");
			}
			else if (level == 23)
			{
				this.add("Multi Maximus Nex (75 mp)");
				this.add("Ultim Ignis (100 mp)");
				this.add("Ultim Stupefacere (100 mp)");
			}
			else if (level == 24)
			{
				this.add("Maximus Radius (100 mp)");
			}
			else if (level == 25)
			{
				this.add("Ultim Flamma Ventus (100 mp)");
			}
			else if (level == 26)
			{
				this.add("Ultim Extrudere (100 mp)");
				this.add("Ultim Noxa Tueri (105 mp)");
			}
			else if (level == 27)
			{
				this.add("Maximus Velocitas (7 mp)");
			}
			else if (level == 28)
			{
				this.add("Vis Adgredi (50 mp)");
			}
			else if (level == 29)
			{
				this.add("Multi Ultim Nex (100 mp)");
				this.add("Vis Tueri (150 mp)");
			}
			else if (level == 30)
			{
				this.add("Ultim Radius (150 mp)");
				this.add("Vis Ignis (150 mp)");
				this.add("Vis Stupefacere (150 mp)");
				this.add("Praesentis Trans (200 mp)");
			}
			else if (level == 32)
			{
				this.add("Vis Flamma Ventus (150 mp)");
			}
			else if (level == 33)
			{
				this.add("Animus Extrudere (150 mp)");
				this.add("Ferocia Noxa Tueri (150 mp)");
			}
			else if (level == 36)
			{
				this.add("Infinitus Adgredi (75 mp)");
				this.add("Multi Animus Nex (125 mp)");
			}
			else if (level == 37)
			{
				this.add("Vis Radius (200 mp)");
				this.add("Infinitus Tueri (200 mp)");
			}
			else if (level == 38)
			{
				this.add("Infintius Ignis (200 mp)");
				this.add("Infintius Stupefacere (200 mp)");
			}
			else if (level == 40)
			{
				this.add("Infinitus Flamma Ventus (200 mp)");
			}
			else if (level == 41)
			{
				this.add("Infinitus Extrudere (200 mp)");
				this.add("Infinitus Noxa Tueri (210 mp)");
			}
			else if (level == 43)
			{
				this.add("Omni Velocitas (7 mp)");
			}
			else if (level == 44)
			{
				this.add("Multi Infinitus Nex (150 mp)");
			}
			else if (level == 45)
			{
				this.add("Omni Adgredi (100 mp)");
				this.add("Infinitus Radius (250 mp)");
			}
			else if (level == 46)
			{
				this.add("Omni Tueri (250 mp)");
			}
			else if (level == 47)
			{
				this.add("Omni Ignis (250 mp)");
				this.add("Omni Stupefacere (250 mp)");
			}
			else if (level == 49)
			{
				this.add("Omni Flamma Ventus (250 mp)");
			}
			else if (level == 50)
			{
				this.add("Omni Extrudere (250 mp)");
				this.add("Omni Noxa Tueri (260 mp)");
			}
			else if (level == 53)
			{
				this.add("Multi Omni Nex (180 mp)");
			}
			else if (level == 54)
			{
				this.add("Omni Radius (310 mp)");
			}
			else if (level == 55)
			{
				this.add("Dirus Adgredi (130 mp)");
			}
			else if (level == 56)
			{
				this.add("Divinus Tueri (320 mp)");
			}
			else if (level == 57)
			{
				this.add("Dirus Ignis (320 mp)");
				this.add("Dirus Stupefacere (320 mp)");
			}
			else if (level == 59)
			{
				this.add("Dirus Flamma Ventus (320 mp)");
			}
			else if (level == 60)
			{
				this.add("Divinus Extrudere (320 mp)");
				this.add("Dirus Noxa Tueri (340 mp)");
			}
			else if (level == 63)
			{
				this.add("Multi Dirus Nex (210 mp)");
			}
			else if (level == 64)
			{
				this.add("Dirus Radius (370 mp)");
			}
			else if (level == 67)
			{
				this.add("Adept Adgredi (180 mp)");
			}
			else if (level == 68)
			{
				this.add("Adept Tueri (400 mp)");
			}
			else if (level == 69)
			{
				this.add("Adept Ignis (400 mp)");
				this.add("Adept Stupefacere (400 mp)");
			}
			else if (level == 71)
			{
				this.add("Adept Flamma Ventus (400 mp)");
			}
			else if (level == 72)
			{
				this.add("Adept Extrudere (400 mp)");
				this.add("Adept Noxa Tueri (420 mp)");
			}
			else if (level == 75)
			{
				this.add("Multi Adept Nex (250 mp)");
			}
			else if (level == 76)
			{
				this.add("Adept Radius (420 mp)");
			}
		}
		else if (cla == 5) //[5]Warlock
		{
			if (level == 1)
			{
				this.add("Minor Adgredi (2 mp)");
				this.add("Minor Venenum (3 mp)");
				this.add("Nocte Visus (4 mp)");
			}
			else if (level == 2)
			{
				this.add("Minor Flamma (3 mp)");
				this.add("Minor Tueri (3 mp)");
				this.add("Emissarius (6 mp)");
				this.add("Emissarius Nex (6 mp)");
			}
			else if (level == 3)
			{
				this.add("Minor Ignis (3 mp)");
				this.add("Minor Stupefacere (3 mp)");
				this.add("Tiron Adgredi (4 mp)");
				this.add("Tiron Venenum (5 mp)");
				this.add("Nonne Sera (7 mp)");
				this.add("Minor Velocitas (7 mp)");
			}
			else if (level == 4)
			{
				this.add("Tiron Tueri (5 mp)");
				this.add("Minor Mederi (2 mp)");
				this.add("Minor Venenum Nimbus (8 mp)");
			}
			else if (level == 5)
			{
				this.add("Minor Sanatio (3 mp)");
				this.add("Tiron Ignis (5 mp)");
				this.add("Tiron Stupefacere (5 mp)");
				this.add("Minor Flamma Ventus (10 mp)");
				this.add("Mutatio Nimbus (12 mp)");
				this.add("Contra Magicus (16 mp)");
				this.add("Mutatio Flamma (16 mp)");
			}
			else if (level == 6)
			{
				this.add("Medius Adgredi (8 mp)");
				this.add("Tiron Venenum Nimbus (10 mp)");
				this.add("Minor Extrudere (13 mp)");
				this.add("Medius Venenum (15 mp)");
				this.add("Contra Visus (18 mp)");
				this.add("Os Saltare (21 mp)");
				this.add("Reditus Cubile (30 mp)");
			}
			else if (level == 7)
			{
				this.add("Minor Robur (8 mp)");
				this.add("Tiron Flamma Ventus (15 mp)");
				this.add("Medius Tueri (15 mp)");
				this.add("Arcessere Flamma (24 mp)");
			}
			else if (level == 8)
			{
				this.add("Medius Ignis (15 mp)");
				this.add("Medius Stupefacere (15 mp)");
				this.add("Tiron Extrudere (18 mp)");
			}
			else if (level == 9)
			{
				this.add("Tiron Robur (10 mp)");
				this.add("Medius Venenum Nimbus (15 mp)");
				this.add("Minor Tabes Viscera (50 mp)");
			}
			else if (level == 10)
			{
				this.add("Tiron Sanatio (6 mp)");
				this.add("Magna Adgredi (12 mp)");
				this.add("Sensus Scientia (13 mp)");
				this.add("Medius Flamma Ventus (20 mp)");
				this.add("Magna Venenum (35 mp)");
			}
			else if (level == 11)
			{
				this.add("Medius Extrudere (26 mp)");
				this.add("Magna Tueri (35 mp)");
				this.add("Minor Lunae Lumen Nex (50 mp)");
				this.add("Tiron Tabes Viscera (55 mp)");
				this.add("Creare Porta (85 mp)");
			}
			else if (level == 12)
			{
				this.add("Medius Robur (15 mp)");
				this.add("Pergere Trans (24 mp)");
				this.add("Magna Ignis (35 mp)");
			}
			else if (level == 13)
			{
				this.add("Medius Mederi (12 mp)");
				this.add("Magna Venenum Nimbus (35 mp)");
				this.add("Tiron Lunae Lumen Nex (55 mp)");
			}
			else if (level == 14)
			{
				this.add("Magna Flamma Ventus (35 mp)");
				this.add("Medius Tabes Viscera (65 mp)");
			}
			else if (level == 15)
			{
				this.add("Magna Sanatio (10 mp)");
				this.add("Maximus Adgredi (17 mp)");
				this.add("Magna Extrudere (35 mp)");
				this.add("Maximus Venenum (60 mp)");
			}
			else if (level == 16)
			{
				this.add("Medius Velocitas (7 mp)");
				this.add("Maximus Tueri (60 mp)");
				this.add("Medius Lunae Lumen Nex (65 mp)");
			}
			else if (level == 17)
			{
				this.add("Maximus Ignis (60 mp)");
			}
			else if (level == 18)
			{
				this.add("Maximus Venenum Nimbus (60 mp)");
				this.add("Magna Tabes Viscera (75 mp)");
			}
			else if (level == 19)
			{
				this.add("Maximus Flamma Ventus (60 mp)");
			}
			else if (level == 20)
			{
				this.add("Maximus Extrudere (60 mp)");
				this.add("Magna Lunae Lumen Nex (75 mp)");
			}
			else if (level == 21)
			{
				this.add("Ultim Adgredi (30 mp)");
				this.add("Ultim Venenum (100 mp)");
			}
			else if (level == 22)
			{
				this.add("Ultim Tueri (100 mp)");
			}
			else if (level == 23)
			{
				this.add("Maximus Tabes Viscera (90 mp)");
				this.add("Ultim Ignis (100 mp)");
			}
			else if (level == 24)
			{
				this.add("Ultim Venenum Nimbus (100 mp)");
			}
			else if (level == 25)
			{
				this.add("Maximus Lunae Lumen Nex (90 mp)");
				this.add("Ultim Flamma Ventus (100 mp)");
			}
			else if (level == 26)
			{
				this.add("Ultim Extrudere (100 mp)");
			}
			else if (level == 28)
			{
				this.add("Vis Adgredi (50 mp)");
				this.add("Ferocia Venenum (150 mp)");
			}
			else if (level == 29)
			{
				this.add("Ultim Tabes Viscera (105 mp)");
				this.add("Vis Tueri (150 mp)");
			}
			else if (level == 30)
			{
				this.add("Vis Ignis (150 mp)");
				this.add("Praesentis Trans (200 mp)");
			}
			else if (level == 31)
			{
				this.add("Ultim Lunae Lumen Nex (105 mp)");
				this.add("Ferocia Venenum Nimbus (150 mp)");
			}
			else if (level == 32)
			{
				this.add("Vis Flamma Ventus (150 mp)");
			}
			else if (level == 33)
			{
				this.add("Animus Extrudere (150 mp)");
			}
			else if (level == 36)
			{
				this.add("Infinitus Adgredi (75 mp)");
				this.add("Ferocia Tabes Viscera (150 mp)");
				this.add("Infinitus Venenum (200 mp)");
			}
			else if (level == 37)
			{
				this.add("Infinitus Tueri (200 mp)");
			}
			else if (level == 38)
			{
				this.add("Vis Lunae Lumen Nex (150 mp)");
				this.add("Infintius Ignis (200 mp)");
			}
			else if (level == 39)
			{
				this.add("Infinitus Venenum Nimbus (200 mp)");
			}
			else if (level == 40)
			{
				this.add("Infinitus Flamma Ventus (200 mp)");
			}
			else if (level == 41)
			{
				this.add("Infinitus Extrudere (200 mp)");
			}
			else if (level == 44)
			{
				this.add("Infinitus Tabes Viscera (210 mp)");
			}
			else if (level == 45)
			{
				this.add("Omni Adgredi (100 mp)");
				this.add("Omni Venenum (250 mp)");
			}
			else if (level == 46)
			{
				this.add("Infinitus Lunae Lumen Nex (210 mp)");
				this.add("Omni Tueri (250 mp)");
			}
			else if (level == 47)
			{
				this.add("Omni Ignis (250 mp)");
			}
			else if (level == 48)
			{
				this.add("Omni Venenum Nimbus (250 mp)");
			}
			else if (level == 49)
			{
				this.add("Omni Flamma Ventus (250 mp)");
			}
			else if (level == 50)
			{
				this.add("Omni Extrudere (250 mp)");
			}
			else if (level == 53)
			{
				this.add("Omni Tabes Viscera (260 mp)");
			}
			else if (level == 55)
			{
				this.add("Dirus Adgredi (130 mp)");
				this.add("Omni Lunae Lumen Nex (260 mp)");
				this.add("Dirus Venenum (320 mp)");
			}
			else if (level == 56)
			{
				this.add("Divinus Tueri (320 mp)");
			}
			else if (level == 57)
			{
				this.add("Dirus Ignis (320 mp)");
			}
			else if (level == 58)
			{
				this.add("Dirus Venenum Nimbus (320 mp)");
			}
			else if (level == 59)
			{
				this.add("Dirus Flamma Ventus (320 mp)");
			}
			else if (level == 60)
			{
				this.add("Divinus Extrudere (320 mp)");
			}
			else if (level == 63)
			{
				this.add("Dirus Tabes Viscera (340 mp)");
			}
			else if (level == 65)
			{
				this.add("Dirus Lunae Lumen Nex (340 mp)");
			}
			else if (level == 67)
			{
				this.add("Adept Adgredi (180 mp)");
				this.add("Adept Venenum (400 mp)");
			}
			else if (level == 68)
			{
				this.add("Adept Tueri (400 mp)");
			}
			else if (level == 69)
			{
				this.add("Adept Ignis (400 mp)");
			}
			else if (level == 70)
			{
				this.add("Adept Venenum Nimbus (400 mp)");
			}
			else if (level == 71)
			{
				this.add("Adept Flamma Ventus (400 mp)");
			}
			else if (level == 72)
			{
				this.add("Adept Extrudere (400 mp)");
			}
			else if (level == 75)
			{
				this.add("Adept Tabes Viscera (420 mp)");
			}
			else if (level == 77)
			{
				this.add("Adept Lunae Lumen Nex (420 mp)");
			}
		}
		else if (cla == 6) //[6]Druid
		{
			if (level == 1){
				this.add("Minor Mederi (2 mp)");
				this.add("Nocte Visus (4 mp)");
			}
			else if (level == 2)
			{
				this.add("Minor Flamma (3 mp)");
				this.add("Minor Incantare (3 mp)");
				this.add("Minor Sanatio (3 mp)");
				this.add("Minor Tueri (3 mp)");
				this.add("Emissarius (6 mp)");
				this.add("Emissarius Nex (6 mp)");
			}
			else if (level == 3)
			{
				this.add("Minor Stupefacere (3 mp)");
				this.add("Minor Velocitas (7 mp)");
				this.add("Nonne Sera (7 mp)");
			}
			else if (level == 4)
			{
				this.add("Tiron Incantare (5 mp)");
				this.add("Tiron Tueri (5 mp)");
				this.add("Minor Robur (8 mp)");
				this.add("Medius Mederi (12 mp)");
			}
			else if (level == 5)
			{
				this.add("Tiron Sanatio (6 mp)");
				this.add("Tiron Stupefacere (5 mp)");
				this.add("Minor Glacialis Viscera (8 mp)");
				this.add("Mutatio Nimbus (12 mp)");
				this.add("Contra Magicus (16 mp)");
			}
			else if (level == 6)
			{
				this.add("Tiron Robur (10 mp)");
				this.add("Minor Extrudere (13 mp)");
				this.add("Contra Visus (18 mp)");
				this.add("Minor Fulgur (20 mp)");
				this.add("Minor Noxa Tueri (50 mp)");
			}
			else if (level == 7)
			{
				this.add("Medius Incantare (15 mp)");
				this.add("Medius Tueri (15 mp)");
				this.add("Tiron Glacialis Viscera (10 mp)");
				this.add("Minor Glacialis Ventus (23 mp)");
				this.add("Arcessere Flamma (24 mp)");
			}
			else if (level == 8)
			{
				this.add("Magna Sanatio (10 mp)");
				this.add("Minor Fragor Ipsum (15 mp)");
				this.add("Medius Stupefacere (15 mp)");
				this.add("Tiron Fulgur (25 mp)");
				this.add("Magna Mederi (30 mp)");
				this.add("Tiron Noxa Tueri (55 mp)");
			}
			else if (level == 9)
			{
				this.add("Medius Robur (15 mp)");
				this.add("Tiron Extrudere (18 mp)");
				this.add("Tiron Glacialis Ventus (30 mp)");
			}
			else if (level == 10)
			{
				this.add("Medius Glacialis Viscera (15 mp)");
				this.add("Tiron Fragor Ipsum (25 mp)");
			}
			else if (level == 11)
			{
				this.add("Magnus Sanatio (25 mp)");
				this.add("Medius Fulgur (35 mp)");
				this.add("Magna Incantare (35 mp)");
				this.add("Magna Tueri (35 mp)");
				this.add("Medius Noxa Tueri (65 mp)");
				this.add("Creare Porta (85 mp)");
			}
			else if (level == 12)
			{
				this.add("Pergere Trans (24 mp)");
				this.add("Magna Stupefacere (35 mp)");
				this.add("Medius Glacialis Ventus (40 mp)");
				this.add("Vis Mederi (85 mp)");
			}
			else if (level == 13)
			{
				this.add("Sensus Scientia (13 mp)");
				this.add("Medius Extrudere (26 mp)");
				this.add("Magna Robur (35 mp)");
				this.add("Medius Fragor Ipsum (40 mp)");
			}
			else if (level == 14)
			{
				this.add("Magna Glacialis Viscera (35 mp)");
			}
			else if (level == 15)
			{
				this.add("Magna Fulgur (48 mp)");
				this.add("Magna Noxa Tueri (75 mp)");
			}
			else if (level == 16)
			{
				this.add("Medius Velocitas (7 mp)");
				this.add("Magna Glacialis Ventus (50 mp)");
				this.add("Maximus Incantare (60 mp)");
				this.add("Maximus Tueri (60 mp)");
				this.add("Ultim Sanatio (60 mp)");
			}
			else if (level == 17)
			{
				this.add("Maximus Stupefacere (60 mp)");
				this.add("Magna Fragor Ipsum (65 mp)");
			}
			else if (level == 18)
			{
				this.add("Magna Extrudere (35 mp)");
				this.add("Maximus Robur (60 mp)");
			}
			else if (level == 20)
			{
				this.add("Maximus Fulgur (60 mp)");
				this.add("Maximus Glacialis Viscera (60 mp)");
				this.add("Maximus Noxa Tueri (90 mp)");
				this.add("Infinitus Mederi (120 mp)");
			}
			else if (level == 21)
			{
				this.add("Maximus Glacialis Ventus (60 mp)");
			}
			else if (level == 22)
			{
				this.add("Maximus Fragor Ipsum (100 mp)");
				this.add("Ultim Incantare (100 mp)");
				this.add("Ultim Tueri (100 mp)");
			}
			else if (level == 23)
			{
				this.add("Ultim Stupefacere (100 mp)");
			}
			else if (level == 24)
			{
				this.add("Maximus Extrudere (60 mp)");
				this.add("Ultim Robur (100 mp)");
				this.add("Animus Sanatio (150 mp)");
			}
			else if (level == 25)
			{
				this.add("Ultim Glacialis Viscera (100 mp)");
			}
			else if (level == 26)
			{
				this.add("Ultim Fulgur (100 mp)");
				this.add("Ultim Noxa Tueri (105 mp)");
			}
			else if (level ==27)
			{
				this.add("Ultim Glacialis Ventus (100 mp)");
			}
			else if (level == 28)
			{
				this.add("Ultim Fragor Ipsum (150 mp)");
			}
			else if (level == 29)
			{
				this.add("Vis Incantare (150 mp)");
				this.add("Vis Tueri (150 mp)");
			}
			else if (level == 30)
			{
				this.add("Ultim Extrudere (100 mp)");
				this.add("Vis Stupefacere (150 mp)");
				this.add("Praesentis Trans (200 mp)");
			}
			else if (level == 31)
			{
				this.add("Animus Robur (150 mp)");
			}
			else if (level == 32)
			{
				this.add("Ferocia Fulgur (150 mp)");
				this.add("Ferocia Glacialis Viscera (150 mp)");
			}
			else if (level == 33)
			{
				this.add("Ferocia Noxa Tueri (150 mp)");
			}
			else if (level == 34)
			{
				this.add("Ferocia Glacialis Ventus (150 mp)");
			}
			else if (level == 35)
			{
				this.add("Vis Fragor Ipsum (200 mp)");
				this.add("Infinitus Sanatio (220 mp)");
			}
			else if (level == 37)
			{
				this.add("Animus Extrudere (150 mp)");
				this.add("Infinitus Incantare (200 mp)");
				this.add("Infinitus Tueri (200 mp)");
			}
			else if (level == 38)
			{
				this.add("Infin Stupefacere (200 mp)");
			}
			else if (level == 39)
			{
				this.add("Infinitus Robur (200 mp)");
			}
			else if (level == 40)
			{
				this.add("Infinitus Glacialis Viscera (200 mp)");
			}
			else if (level == 41)
			{
				this.add("Infinitus Fulgur (200 mp)");
				this.add("Infinitus Noxa Tueri (210 mp)");
			}
			else if (level == 42)
			{
				this.add("Infinitus Glacialis Ventus (200 mp)");
			}
			else if (level == 43)
			{
				this.add("Infinitus Fragor Ipsum (250 mp)");
			}
			else if (level == 45)
			{
				this.add("Infinitus Extrudere (200 mp)");
			}
			else if (level == 46)
			{
				this.add("Omni Incantare (250 mp)");
				this.add("Omni Tueri (250 mp)");
			}
			else if (level == 47)
			{
				this.add("Omni Stupefacere (250 mp)");
			}
			else if (level == 48)
			{
				this.add("Omni Robur (250 mp)");
			}
			else if (level == 49)
			{
				this.add("Omni Glacialis Viscera (250 mp)");
			}
			else if (level == 50)
			{
				this.add("Omni Fulgur (250 mp)");
				this.add("Omni Noxa Tueri (260 mp)");
			}
			else if (level == 51)
			{
				this.add("Omni Glacialis Ventus (250 mp)");
			}
			else if (level == 52)
			{
				this.add("Omni Fragor Ipsum (310 mp)");
			}
			else if (level == 54)
			{
				this.add("Omni Extrudere (250 mp)");
			}
			else if (level == 56)
			{
				this.add("Dirus Incantare (320 mp)");
				this.add("Divinus Tueri (320 mp)");
			}
			else if (level == 57)
			{
				this.add("Dirus Stupefacere (320 mp)");
			}
			else if (level == 58)
			{
				this.add("Divinus Robur (320 mp)");
			}
			else if (level == 59)
			{
				this.add("Dirus Glacialis Viscera (320 mp)");
			}
			else if (level == 60)
			{
				this.add("Dirus Fulgur (320 mp)");
				this.add("Dirus Noxa Tueri (340 mp)");
			}
			else if (level == 61)
			{
				this.add("Dirus Glacialis Ventus (320 mp)");
			}
			else if (level == 62)
			{
				this.add("Dirus Fragor Ipsum (370 mp)");
			}
			else if (level == 64)
			{
				this.add("Divinus Extrudere (320 mp)");
			}
			else if (level == 68)
			{
				this.add("Adept Incantare (400 mp)");
				this.add("Adept Tueri (400 mp)");
			}
			else if (level == 69)
			{
				this.add("Adept Stupefacere (400 mp)");
			}
			else if (level == 70)
			{
				this.add("Adept Robur (400 mp)");
			}
			else if (level == 71)
			{
				this.add("Adept Glacialis Viscera (400 mp)");
			}
			else if (level == 72)
			{
				this.add("Adept Fulgur (400 mp)");
				this.add("Adept Noxa Tueri (420 mp)");
			}
			else if (level == 73)
			{
				this.add("Adept Glacialis Ventus (400 mp)");
			}
			else if (level == 74)
			{
				this.add("Adept Fragor Ipsum (420 mp)");
			}
			else if (level == 76)
			{
				this.add("Adept Extrudere (400 mp)");
			}
		}
		else if (cla == 7) //[7]Darkwar
		{
			if (level == 1)
			{
				this.add("Hide Skill (0 mp)");
				this.add("Nocte Visus (4 mp)");
			}
			else if (level == 2)
			{
				this.add("Minor Flamma (3 mp)");
				this.add("Emissarius (6 mp)");
				this.add("Emissarius Nex (6 mp)");
			}
			else if (level == 3)
			{
				this.add("Attack Run Minor (1 mp)");
				this.add("Double Slice (3 mp)");
			}
			else if (level == 4)
			{
				this.add("Minor Mederi (2 mp)");
				this.add("Tiron Flamma (5 mp)");
			}
			else if (level == 5)
			{
				this.add("Attack Run Tiron (2 mp)");
				this.add("Minor Juxta Flamma (3 mp)");
				this.add("Minor Sanatio (3 mp)");
				this.add("Minor Tueri (3 mp)");
				this.add("Double Stab (8 mp)");
			}
			else if (level == 6)
			{
				this.add("Minor Stupefacere (3 mp)");
				this.add("Minor Velocitas (7 mp)");
				this.add("Nonne Sera (7 mp)");
			}
			else if (level == 7)
			{
				this.add("Tiron Juxta Flamma (5 mp)");
				this.add("Tiron Tueri (5 mp)");
				this.add("Minor Robur (8 mp)");
				this.add("Medius Flamma (10 mp)");
			}
			else if (level == 8)
			{
				this.add("Attack Run Medius (3 mp)");
				this.add("Tiron Stupefacere (5 mp)");
				this.add("Mutatio Nimbus (12 mp)");
				this.add("Contra Magicus (16 mp)");
			}
			else if (level == 9)
			{
				this.add("Tiron Robur (10 mp)");
				this.add("Minor Extrudere (13 mp)");
				this.add("Contra Visus (18 mp)");
			}
			else if (level == 10)
			{
				this.add("Tiron Sanatio (6 mp)");
				this.add("Medius Juxta Flamma (10 mp)");
				this.add("Medius Tueri (15 mp)");
				this.add("Arcessere Flamma (24 mp)");
			}
			else if (level == 11)
			{
				this.add("Medius Stupefacere (15 mp)");
				this.add("Magna Flamma (15 mp)");
			}
			else if (level == 12)
			{
				this.add("Attack Run Magna (5 mp)");
				this.add("Back Spin (15 mp)");
				this.add("Medius Robur (15 mp)");
				this.add("Tiron Extrudere (18 mp)");
				this.add("Pergere Trans (24 mp)");
			}
			else if (level == 13)
			{
				this.add("Medius Mederi (12 mp)");
				this.add("Sensus Scientia (13 mp)");
			}
			else if (level == 14)
			{
				this.add("Magna Juxta Flamma (15 mp)");
				this.add("Magna Tueri (35 mp)");
			}
			else if (level == 15)
			{
				this.add("Magna Sanatio (10 mp)");
				this.add("Magna Stupefacere (35 mp)");
			}
			else if (level == 16)
			{
				this.add("Medius Velocitas (7 mp)");
				this.add("Maximus Flamma (25 mp)");
				this.add("Medius Extrudere (26 mp)");
			}
			else if (level == 17)
			{
				this.add("Attack Run Maximus (10 mp)");
				this.add("Jump attack (20 mp)");
			}
			else if (level == 19)
			{
				this.add("Maximus Juxta Flamma (25 mp)");
				this.add("Maximus Tueri (60 mp)");
			}
			else if (level == 20)
			{
				this.add("Maximus Stupefacere (60 mp)");
			}
			else if (level == 21)
			{
				this.add("Magna Extrudere (35 mp)");
			}
			else if (level == 22)
			{
				this.add("Ultim Flamma (45 mp)");
			}
			else if (level == 23)
			{
				this.add("Attack Run Ultim (15 mp)");
				this.add("Stab & Slice (25 mp)");
			}
			else if (level == 25)
			{
				this.add("Ultim Juxta Flamma (45 mp)");
				this.add("Ultim Tueri (100 mp)");
			}
			else if (level == 26)
			{
				this.add("Ultim Stupefacere (100 mp)");
			}
			else if (level == 27)
			{
				this.add("Maximus Extrudere (60 mp)");
			}
			else if (level == 29)
			{
				this.add("Ferocia Flamma (75 mp)");
			}
			else if (level == 30)
			{
				this.add("Attack Run Ferocia (20 mp)");
			}
			else if (level == 32)
			{
				this.add("Ferocia Juxta Flamma (75 mp)");
				this.add("Vis Tueri (150 mp)");
			}
			else if (level == 33)
			{
				this.add("Vis Stupefacere (150 mp)");
			}
			else if (level == 37)
			{
				this.add("Infinitus Flamma (110 mp)");
			}
			else if (level == 38)
			{
				this.add("Attack Run Infinitus (25 mp)");
				this.add("Tornado Slice (35 mp)");
			}
			else if (level == 40)
			{
				this.add("Infinitus Juxta Flamma (110 mp)");
				this.add("Infinitus Tueri (200 mp)");
			}
			else if (level == 41)
			{
				this.add("Infin Stupefacere (200 mp)");
			}
			else if (level == 46)
			{
				this.add("Omni Flamma (150 mp)");
			}
			else if (level == 47)
			{
				this.add("Attack Run Omni (30 mp)");
			}
			else if (level == 49)
			{
				this.add("Omni Juxta Flamma (150 mp)");
				this.add("Omni Tueri (250 mp)");
			}
			else if (level == 50)
			{
				this.add("Omni Stupefacere (250 mp)");
			}
			else if (level == 56)
			{
				this.add("Dirus Flamma (220 mp)");
			}
			else if (level == 57)
			{
				this.add("Attack Run Dirus (35 mp)");
			}
			else if (level == 59)
			{
				this.add("Dirus Juxta Flamma (220 mp)");
				this.add("Divinus Tueri (320 mp)");
			}
			else if (level == 60)
			{
				this.add("Dirus Stupefacere (320 mp)");
			}
			else if (level == 68)
			{
				this.add("Adept Flamma (300 mp)");
			}
			else if (level == 69)
			{
				this.add("Attack Run Adept (40 mp)");
			}
			else if (level == 71)
			{
				this.add("Adept Juxta Flamma (300 mp)");
				this.add("Adept Tueri (400 mp)");
			}
			else if (level == 72)
			{
				this.add("Adept Stupefacere (400 mp)");
			}
		}
		else if (cla == 8) //[8]Barbarian
		{
			if (level == 2)
			{
				this.add("Emissarius (6 mp)");
				this.add("Emissarius Nex (6 mp)");
			}
			else if (level == 3)
			{
				this.add("Double Slice (3 mp)");
			}
			else if (level == 5)
			{
				this.add("Double Stab (8 mp)");
			}
			else if (level == 6)
			{
				this.add("Minor Flamma (3 mp)");
				this.add("Minor Velocitas (7 mp)");
				this.add("Nonne Sera (7 mp)");
			}
			else if (level == 8)
			{
				this.add("Mutatio Nimbus (12 mp)");
				this.add("Shield Bash (12 mp)");
			}
			else if (level == 12)
			{
				this.add("Back Spin (15 mp)");
			}
			else if (level == 13)
			{
				this.add("Sensus Scientia (13 mp)");
			}
			else if (level == 15)
			{
				this.add("Attack Run Minor (1 mp)");
			}
			else if (level == 16)
			{
				this.add("Minor Spin (5 mp)");
				this.add("Medius Velocitas (7 mp)");
			}
			else if (level == 17)
			{
				this.add("Attack Run Tiron (2 mp)");
				this.add("Jump attack (20 mp)");
			}
			else if (level == 18)
			{
				this.add("Tiron Spin (10 mp)");
			}
			else if (level == 20)
			{
				this.add("Attack Run Medius (3 mp)");
			}
			else if (level == 21)
			{
				this.add("Medius Spin (15 mp)");
			}
			else if (level == 23)
			{
				this.add("Stab & Slice (25 mp)");
			}
			else if (level == 24)
			{
				this.add("Attack Run Magna (5 mp)");
			}
			else if (level == 25)
			{
				this.add("Magna Spin (20 mp)");
			}
			else if (level == 29)
			{
				this.add("Attack Run Maximus (10 mp)");
			}
			else if (level == 30)
			{
				this.add("Maximus Spin (25 mp)");
				this.add("Bash & Stab (30 mp)");
			}
			else if (level == 35)
			{
				this.add("Attack Run Ultim (15 mp)");
			}
			else if (level == 36)
			{
				this.add("Ultim Spin (30 mp)");
			}
			else if (level == 38)
			{
				this.add("Tornado Slice (35 mp)");
			}
			else if (level == 42)
			{
				this.add("Attack Run Ferocia (20 mp)");
			}
			else if (level == 43)
			{
				this.add("Ferocia Spin (35 mp)");
			}
			else if (level == 50)
			{
				this.add("Attack Run Infinitus (25 mp)");
			}
			else if (level == 51)
			{
				this.add("Infinitus Spin (40 mp)");
			}
			else if (level == 59)
			{
				this.add("Attack Run Omni (30 mp)");
			}
			else if (level == 60)
			{
				this.add("Omni Spin (45 mp)");
			}
			else if (level == 69)
			{
				this.add("Attack Run Dirus (35 mp)");
			}
			else if (level == 70)
			{
				this.add("Dirus Spin (50 mp)");
			}
			else if (level == 81)
			{
				this.add("Attack Run Adept (40 mp)");
			}
			else if (level == 82)
			{
				this.add("Adept Spin (55 mp)");
			}
		}
	}
	
	
	private void add(String addition)
	{
		String [] temp = new String[spells.length+1];
		
		for(int i=0; i<spells.length; i++)
		{
			temp[i] = spells[i];
		}
		
		temp[spells.length] = addition;
		
		spells = new String[temp.length];
		
		for(int i=0; i<spells.length; i++)
		{
			spells[i]   = temp[i];
		}
	}
	
	
	public String [] get()
	{
		return spells;
	}
}