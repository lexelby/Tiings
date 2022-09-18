package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_73b
   extends TilingType
{
   public TilingTypeNC5_73b(){
      super( "NC5-73b", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,0,1, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 2,1, 2,0,1, 0},
      };
      info = "a=e\nb=c\nA=120\nB=60\nC=60\nD=240\n(E=60)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 0.8;
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
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(3);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(3);
      offsets[2] = tiles[3].getX(3)-tiles[0].getX(4);
      offsets[3] = tiles[3].getY(3)-tiles[0].getY(4);
   }
}
