package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_03a
   extends TilingType
{
   public TilingTypeNC6_03a(){
      super( "NC6-3a", 6, SymmetryType.pg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,2,3, 1},
            {1, 4,5, 1,0,5, 1},
            {1, 3,4, 2,0,1, 0},
      };
      info = "a=b=c=d=e=f\nA=108\nB=108\nC=72\nD=252\n(E=36)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .5;
      double c = w * Math.cos(72 * DEG2RAD);
      double s = w * Math.sin(72 * DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,w+c,  s);
      baseTile.setPoint(3,  c,  s);
      baseTile.setPoint(4,  0,s+s);
      baseTile.setPoint(5, -c,  s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(1)-tiles[0].getX(4);
      offsets[3] = tiles[2].getY(1)-tiles[0].getY(4);
   }
}