package org.example;

import environment.Location;
import environment.WorldMap;
import input.LoadLocationFromFile;
import input.LoadMapFromFile;
import npc.Goblin;
import npc.HostileNpcRace;
import player.Player;
import player.PlayerRole;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap();
        Player player = new Player(PlayerRole.KNIGHT, worldMap);
        Location location;



//        LoadMapFromFile loadMap = new LoadMapFromFile(worldMap);
//        LoadLocationFromFile locationLoad = new LoadLocationFromFile();
//        try {
//            loadMap.loadConnectionsFromFile("maps/defaultMap.txt", locationLoad);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        worldMap.printWorldMap();
//        System.out.println("");
//        if (worldMap.isAdjacent(worldMap.getLocationByName("Town"), worldMap.getLocationByName("Dungeon"))){
//            System.out.println("Adjacent");
//        }
//
//        worldMap.printAdjacentLocations(worldMap.getLocationByName("Town"));
//        Location town = worldMap.getLocationByName("Town");
//        town.printLocation();

        Goblin goblin = new Goblin(HostileNpcRace.GOBLIN,3,3);
        System.out.println(goblin.getSymbol());
    }
}