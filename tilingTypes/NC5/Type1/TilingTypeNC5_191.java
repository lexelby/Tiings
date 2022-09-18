package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_191
   extends TilingType
{
   public TilingTypeNC5_191(){
      super( "NC5-191", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 50, 60};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,4,0, 1},
            {1, 3,0, 1,0,3, 1},
            {0, 4,0, 2,3,4, 0},

            {0, 2,3, 0,0,1, 1},
            {1, 3,4, 4,4,0, 0},
            {1, 3,0, 5,0,3, 0},
            {0, 4,0, 6,3,4, 1},
      };
      info = "a=e\nb=d\nC=D\nB+C=360\n(A+D+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = 1.0;
      double a = getParam(paramValues,0);
      double c1 = Math.cos( a/2 * DEG2RAD);
      double s1 = Math.sin( a/2 * DEG2RAD);
      double diag = 2 * lna * s1;
      double lnc = diag * getParam(paramValues,1)/100;
      lnc = Math.min(lnc,lna);
      
      double tanb = c1 * diag / (diag * s1 - lnc);
      double b = Math.atan(tanb)/DEG2RAD;
      
      double ang = 270 -a/2 -2*b;
      double dx = lnc/2 * Math.cos( ang * DEG2RAD);
      double dy = lnc/2 * Math.sin( ang * DEG2RAD);
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, diag/2-dx, dy);
      baseTile.setPoint(2, diag/2+dx, -dy);
      baseTile.setPoint(3, diag, 0);
      baseTile.setPoint(4, diag/2, lna * c1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[4].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[4].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(2);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(2);
   }
}
