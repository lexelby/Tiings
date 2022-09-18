package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_35a
   extends TilingType
{
   public TilingTypeNC6_35a(){
      super( "NC6-35a", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,180,360};
      paramDef = new int[]{ 40, 80,150};
      paramName = new String[]{"Relative Length", "Angle", "Indentation Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,5, 0,2,0, 0},
            {1, 0,1, 1,1,0, 0},
            {0, 2,0, 2,3,5, 0},

            {0, 4,5, 0,3,4, 1},
            {1, 3,5, 4,2,0, 1},
            {1, 0,1, 5,1,0, 1},
            {0, 2,0, 6,3,5, 1},
      };
      info = "b=c=e=f\na=d\nB+E=360\nA+B+C=360\n(D+E+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double ln2 = lntotal * getParam(paramValues, 0)/100;
      double ln1 = (lntotal - ln2)/2;
      double a = getParam(paramValues, 1);
      double b = getParam(paramValues, 2);
      double mx1 = 2 * (90 - Math.abs(a-90) );
      if( b < 180-mx1 ) b = 180-mx1;
      if( b > 180+mx1 ) b = 180+mx1;

      double c2 = ln2 * Math.cos(a * DEG2RAD);
      double s2 = ln2 * Math.sin(a * DEG2RAD);
      double c1 = ln1 * Math.cos((90-b/2) * DEG2RAD);
      double s1 = ln1 * Math.sin((90-b/2) * DEG2RAD);

      baseTile.setPoint(0,    0   ,  0);
      baseTile.setPoint(1,   c1   , s1);
      baseTile.setPoint(2, 2*c1   ,  0);
      baseTile.setPoint(3, 2*c1+c2, s2);
      baseTile.setPoint(4,   c1+c2, s2+s1);
      baseTile.setPoint(5,      c2, s2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(4)-tiles[3].getX(5);
      offsets[3] = tiles[7].getY(4)-tiles[3].getY(5);
   }
}