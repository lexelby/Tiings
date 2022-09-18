package tilingTypes.P5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP5_12
   extends TilingType
{
   public TilingTypeP5_12(){
      super( "P5-12: Type 1", 5, SymmetryType.pgg );

      paramMin = new int[]{-90,  0,   0,  0};
      paramMax = new int[]{ 90,100, 100, 90};
      paramDef = new int[]{ 10, 60,  70, 60};
      paramName = new String[]{ "Angle", "Relative length", "Side split", "Point angle"};
      // 0=ori, 1=scale=horiz width,  2=angle of parallel sides, 3=hor/vert ratio, 4=parside split, 5=dist

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            {0, 1,2, 1,0,1, 1},
            {0, 2,3, 2,3,2, 1},
            };
      info = "b=c+e\nC+D=180\n(A+B+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 1.5 * paramValues[1]/100.; //vertical sides of hexagon
      double ln1 = 1.5 - ln2;   // point sides of hexagon
      double dx1 = ln2 * Math.sin( paramValues[0]* DEG2RAD); // sides
      double dy1 = ln2 * Math.cos( paramValues[0]* DEG2RAD); // sides
      double f = getParam( paramValues,2)/100.; //side split
      double dx2 = ln1 * Math.sin( paramValues[3]* DEG2RAD); // point
      double dy2 = ln1 * Math.cos( paramValues[3]* DEG2RAD); // point

      double x1 =  dx2;
      double y1 = -dy2  ;
      double x2 = dx2*(1+f);
      double y2 = -dy2*(1-f);
      double x4 = dx1;
      double y4 = dy1;
      double x3 = dx1+(1-f)*dx2;
      double y3 = dy1+(1-f)*dy2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(1);
   }
}
