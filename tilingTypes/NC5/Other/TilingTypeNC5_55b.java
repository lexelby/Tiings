package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_55b
   extends TilingType
{
   public TilingTypeNC5_55b(){
      super( "NC5-55b", 5, SymmetryType.pgg );

      paramMin = new int[]{   0};
      paramMax = new int[]{ 100};
      paramDef = new int[]{  50};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,2,3, 0},
            {0, 0,1, 1,2,3, 1},
            {1, 2,1, 2,2,3, 1},

            {1, 4,0, 3,0,4, 1},
            {0, 2,3, 4,2,1, 1},
            {0, 0,1, 4,2,3, 0},
            {1, 2,1, 6,2,3, 0},
      };
      info = "b=c=d\na+b=e\nC=E\nB+D=360\n(A+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = paramValues[0] / 100.;
      double w = 1 - h + Math.sqrt(3);
      h *= .5;
      w *= .5;
      double an = 2*Math.atan2(h,w);
      double t = Math.tan(an)/2;
      double c = t*w;
      double s = t*h;
      
      double xB =   w/2 - s;
      double yB =   h/2 + c;
      double xD =   w/2 + s;
      double yD = 3*h/2 + c;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, xB, yB);
      baseTile.setPoint(2,  w,  h);
      baseTile.setPoint(3, xD, yD);
      baseTile.setPoint(4, -w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(4)-tiles[1].getX(0);
      offsets[1] = tiles[6].getY(4)-tiles[1].getY(0);
      offsets[2] = tiles[3].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(2)-tiles[0].getY(0);
   }
}
