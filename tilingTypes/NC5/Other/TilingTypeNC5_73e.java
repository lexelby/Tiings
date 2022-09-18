package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_73e
   extends TilingType
{
   public TilingTypeNC5_73e(){
      super( "NC5-73e (Chirag Mehta)", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,0,4, 0},
            {2, 3,4, 1,0,4, 0},
            {0, 3,4, 2,0,4, 0},
            {1, 3,4, 3,0,4, 0},
            {2, 3,4, 4,0,4, 0},
            {3, 1,0, 0,1,2, 0},
            {3, 1,0, 3,1,2, 0},
      };
      info = "a=e\nb=c\nA=120\nB=60\nC=60\nD=240\n(E=60)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 0.6;
      double ln2 = lntotal * getParam(paramValues,0)/200.;
      double ln1 = lntotal - ln2;
      double h = Math.sqrt(3);
      
      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1,2*ln1,  0);
      baseTile.setPoint(2,  ln1,  h*ln1);
      baseTile.setPoint(3,  ln2,  h*ln2);
      baseTile.setPoint(4, -ln2,  h*ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(2)-tiles[7].getX(3);
      offsets[1] = tiles[6].getY(2)-tiles[7].getY(3);
      offsets[2] = tiles[5].getX(2)-tiles[2].getX(1);
      offsets[3] = tiles[5].getY(2)-tiles[2].getY(1);
   }
}
