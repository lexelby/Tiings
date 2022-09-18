package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_35a
   extends TilingType
{
   public TilingTypeN4_35a(){
      super( "N4-35a", 4, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 67, 20};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {2, 1,2, 0,1,2, 1},
            {1, 2,3, 1,2,3, 0},
            {1, 1,0, 2,0,1, 0},
            {2, 2,3, 3,2,3, 1},
            {0, 1,2, 4,1,2, 0},
      };
      info = "A=90\nB=90\nC=60\n(D=120)";
   }

   public void recalcBase(double[] paramValues) {
      double w = getParam(paramValues,0)/100;
      double h = 1-w;
      double h2 = h + w/Math.sqrt(3);
    
      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w, h2);
      baseTile.setPoint(3, 0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = paramValues[1]/100.;
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[4].getX(0)-tiles[0].getX(0) - os*offsets[0];
      offsets[3] = tiles[4].getY(0)-tiles[0].getY(0) - os*offsets[1];
   }
}
