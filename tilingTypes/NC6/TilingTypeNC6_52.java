package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_52
   extends TilingType
{
   public TilingTypeNC6_52(){
      super( "NC6-52", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{140, 60};
      paramName = new String[]{"Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 5,2, 1,2,5, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 4,0, 0,2,4, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 5,2, 5,2,5, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=c=e\nd=f\nD+E=360\nE=F\nA=B\n(A+B+C+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 1.0;
      double ln1 = lntotal * getParam(paramValues, 1)/100;
      double ln2 = lntotal - ln1;

      double ef = getParam(paramValues, 0);
      double diag = calcSide(ln1,ln2/2,ef);
      double x = calcAngle(ln1,diag,ln2/2);
      double c = ef - 2*x;
      
      double c1 = ln2 * Math.cos((180-ef) * DEG2RAD);
      double s1 = ln2 * Math.sin((180-ef) * DEG2RAD);
      double c2 = ln2 * Math.cos((180-c) * DEG2RAD);
      double s2 = ln2 * Math.sin((180-c) * DEG2RAD);
      
      baseTile.setPoint(0,         0,  0);
      baseTile.setPoint(5,        c1, s1);
      baseTile.setPoint(4,  ln1+  c1, s1);
      baseTile.setPoint(3,  ln1+2*c1,  0);
      baseTile.setPoint(2,2*ln1+2*c1,  0);
      baseTile.setPoint(1,2*ln1+2*c1+c2, -s2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(2)-tiles[3].getX(4);
      offsets[3] = tiles[7].getY(2)-tiles[3].getY(4);
   }
}