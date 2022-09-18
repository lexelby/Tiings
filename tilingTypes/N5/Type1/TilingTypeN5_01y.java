package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01y
   extends TilingType
{
   public TilingTypeN5_01y(){
      super( "N5-1y", 5, SymmetryType.p2 );

      paramMin = new int[]{ 60};
      paramMax = new int[]{180};
      paramDef = new int[]{ 80};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,0, 0,1,2, 0},
            {0, 2,1, 1,1,2, 0},
            {1, 1,2, 2,1,0, 0},
      };
      info = "b=c\nd=c+e\nA+E=180\nB=D\nC=E\n(B+D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double a = getParam(paramValues,0);
      double c = 180-a;
      double b = 180-c/2;
      
      double ln1 = 1;
      double h = 2*ln1 * Math.sin(b*DEG2RAD);
      double t1 = Math.tan((90-a)*DEG2RAD);
      double t2 = Math.tan((b-90)*DEG2RAD);
      double w = ln1 - h*t1;
      double h2 = w/(t1+t2);
      double sd = h2 / Math.sin(c/2 * DEG2RAD);
      // ln2 =  w*f = sd*(1-f)
      // w*f = sd - sd*f
      // (w+sd)*f = sd
      double ln2 = w * sd / (w+sd);
      // scale
      double f = 1/(ln1+ln2);
      ln1*=f;
      ln2*=f;
      
      double ln3 = ln1+ln2;
      
      double x2 = ln1 - ln1 * Math.cos(b*DEG2RAD);
      double y2 =       ln1 * Math.sin(b*DEG2RAD);
      double x3 = x2+   ln3 * Math.cos((-b-c)*DEG2RAD);
      double y3 = y2+   ln3 * Math.sin((-b-c)*DEG2RAD);
      
      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, ln1,   0);
      baseTile.setPoint(2,  x2,  y2);
      baseTile.setPoint(3,  x3,  y3);
      baseTile.setPoint(4,x3-ln2, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(3)-tiles[2].getX(4);
      offsets[3] = tiles[0].getY(3)-tiles[2].getY(4);
   }
}
