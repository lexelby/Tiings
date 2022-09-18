package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_276
   extends TilingType
{
   public TilingTypeNC5_276(){
      super( "NC5-276", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 40};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 4,0, 0,0,4, 0},
            {2, 4,0, 1,1,0, 0},
            {1, 2,1, 0,1,2, 0},
            {0, 4,0, 3,0,4, 0},
            {2, 4,0, 4,1,0, 0},
      };
      info = "a=b+d\nb=c+d\nA=B\nB+C=360\n(A+D+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = 2.5;
      
      double a = getParam(paramValues, 0);
      double s = Math.sin(a*DEG2RAD);
      double c = Math.cos(a*DEG2RAD);
      double maxlnc = a<60 ? .5/c : 1; 
      double lnc = maxlnc * getParam(paramValues, 1)/100;
      double lnd = 1 - lnc;
      double lnb = lnc + lnd;
      double lna = lnb + lnd;

      double x4 = lna * c;
      double y4 = lna * s;
      double x2 = lnb - lnc * c;
      double y23=       lnc * s;
      double x3 = x2 + lnd;
      
      // scale it
      double lne = Math.sqrt((x3-x4)*(x3-x4)+(y23-y4)*(y23-y4));
      double f = ln / (lna+lnb+lnc+lnd+lne);
      x4 *=f;
      y4 *=f;
      y23*=f;
      x2*=f;
      x3*=f;
      lnb*=f;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, x2, y23);
      baseTile.setPoint(3, x3, y23);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(1)-tiles[2].getX(2);
      offsets[1] = tiles[5].getY(1)-tiles[2].getY(2);
      offsets[2] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(3)-tiles[0].getY(0);
   }
}
