package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_37
   extends TilingType
{
   public TilingTypeNC6_37(){
      super( "NC6-37", 6, SymmetryType.pg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,180};
      paramDef = new int[]{ 40, 80};
      paramName = new String[]{"Relative Length", "Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,0,5, 0},

            {0, 1,0, 1,0,5, 1},
            {1, 1,2, 2,0,5, 1},
      };
      info = "a=b=c=e\nd=f\nA+B=180\nE=F\nC+F=360\n(D+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double ln2 = lntotal * getParam(paramValues, 0)/100;
      double ln1 = lntotal - ln2;
      double a = getParam(paramValues, 1);
      double f = 180-a/2;

      double c1 = ln1 * Math.cos(a * DEG2RAD);
      double s1 = ln1 * Math.sin(a * DEG2RAD);
      double c2 = ln2 * Math.cos((a-180+f) * DEG2RAD);
      double s2 = ln2 * Math.sin((a-180+f) * DEG2RAD);

      baseTile.setPoint(0,    0      ,  0);
      baseTile.setPoint(1,  ln1      ,  0);
      baseTile.setPoint(2,  ln1+c1   , s1);
      baseTile.setPoint(3,  ln1+c1+c2, s1+s2);
      baseTile.setPoint(4,      c1+c2, s1+s2);
      baseTile.setPoint(5,      c1   , s1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[3].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[3].getY(0);
   }
}